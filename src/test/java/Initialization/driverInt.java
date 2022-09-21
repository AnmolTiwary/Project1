package Initialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import locatorAndContrains.HomePage;

public class driverInt {
	public WebDriver driver;
	//public HomePage landingPage;
	public WebDriver driverInitialization() throws IOException
	{
		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		
		else if(browserName.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	//to take Screenshot
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testcaseName+ ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException
	{
		driver = driverInitialization();
		HomePage landingPage = new HomePage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();
	}


}
