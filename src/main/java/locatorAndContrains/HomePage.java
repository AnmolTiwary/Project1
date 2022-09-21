package locatorAndContrains;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	By submit = By.cssSelector("button[type='submit']");
//article publishing
	By Title = By.cssSelector("input[placeholder='Article Title']");
	By aboutArticle = By.cssSelector("input[placeholder=\"What's this article about?\"]");
	By articleBody = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
	By articleTags = By.cssSelector("input[placeholder='Enter tags']");
	By publish = By.cssSelector("[type='button']");
//By verification= By.cssSelector("h1[class='ng-binding'");
	By profile = By.cssSelector("a.nav-link.ng-binding");
	By headline = By.cssSelector("h1.ng-binding");
//By body= By.cssSelector("div.ng-binding");
	By home = By.xpath("//a[contains(text(),'Home')]");
	By globalfeed = By.xpath("//a[contains(text(),'Global Feed')]");
	By favtitle = By.xpath("(//h1['.ng-binding'])[3]");
	By fav = By.xpath("(//favorite-btn[@class='pull-xs-right ng-scope ng-isolate-scope'])[2]");
	By favarticle = By.xpath("(//a[contains(text(),'Favorited Articles')])");
	By favlist = By.xpath("(//div[@class='article-preview'])[1]");
	By comment = By.cssSelector("textarea[placeholder='Write a comment...']");
	By checkComment = By.xpath("(//div[@class='card-block'])[4]");
	By titleVerify = By.cssSelector("h1[class='ng-binding']");

//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement titleVerification() {
		return driver.findElement(titleVerify);
	}

	public WebElement Comment() {
		return driver.findElement(comment);
	}

	public WebElement commentCheck() {
		return driver.findElement(checkComment);
	}

	public WebElement favButton() {
		return driver.findElement(fav);
	}

	public WebElement Favarticle() {
		return driver.findElement(favarticle);
	}

	public WebElement Favlist() {
		return driver.findElement(favlist);
	}

	public WebElement Home() {
		return driver.findElement(home);
	}

	public WebElement Globalfeed() {
		return driver.findElement(globalfeed);
	}

	public WebElement userProfile() {
		return driver.findElement(profile);
	}

	public WebElement favArtTitle() {
		return driver.findElement(favtitle);
	}

	public WebElement Submit() {
		return driver.findElement(submit);
	}

	public WebElement articleTitle() {
		return driver.findElement(Title);
	}

	public WebElement AboutArticle() {
		return driver.findElement(aboutArticle);
	}

	public WebElement ArticleBody() {
		return driver.findElement(articleBody);
	}

	public WebElement ArticleTags() {
		return driver.findElement(articleTags);
	}

	public WebElement PublishArticle() {
		return driver.findElement(publish);
	}

	public void goTo() {
		driver.get("https://demo.realworld.io/#/");
	}

}
