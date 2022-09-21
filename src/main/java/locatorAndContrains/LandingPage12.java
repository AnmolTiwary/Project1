package locatorAndContrains;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage12 {
	WebDriver driver;
	LandingPage12 Landing;

	// HomePage locators;
	public LandingPage12(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signin;
	@FindBy(css = "input[placeholder='Email']")
	WebElement Email;
	@FindBy(css = "input[placeholder='Password']")
	WebElement Password;
	@FindBy(css = "button[type='submit']")
	WebElement submit;
	@FindBy(css = ".nav-link[ui-sref='app.editor']")
	WebElement newArticle;
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	WebElement signup;
	@FindBy(css = "input[placeholder='Username']")
	WebElement Username;
	@FindBy(css = "[class='ng-binding ng-scope']")
	WebElement errormsg;
	@FindBy(css = "a[ui-sref='app.settings']")
	WebElement profileSetting;
	@FindBy(xpath = "//button[contains(text(),'Or click here to logout.')]")
	WebElement logout;

//for article submission and comment check
	public LandingPage12 launchApplication() {
		signin.click();
		Email.sendKeys("anmol@abc.com");
		Password.sendKeys("anmoltiwary");
		submit.click();
		newArticle.click();
		Landing = new LandingPage12(driver);
		return Landing;

	}

	// for login test
	public LandingPage12 loginApplication(String email, String password) {
		signin.click();
		Email.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		Landing = new LandingPage12(driver);
		return Landing;

	}

	// for sign up test
	public LandingPage12 signupApplication(String username, String email, String password) {
		signup.click();
		Username.sendKeys(username);
		Email.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		Landing = new LandingPage12(driver);
		return Landing;

	}

	public String errorMsg() {
		String errorMessage = errormsg.getText();
		return errorMessage;
	}

	public LandingPage12 Logout() {
		profileSetting.click();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,1000)");
		
		logout.click();
		Landing = new LandingPage12(driver);
		return Landing;
	}

}
