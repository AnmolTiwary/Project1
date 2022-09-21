package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import Initialization.driverInt;
import locatorAndContrains.HomePage;
import locatorAndContrains.LandingPage12;

public class postArticleTest extends driverInt {
	HomePage locators;
	LandingPage12 land;

	@Test
	public void withoutArticleTitle()

	{
		locators = new HomePage(driver);
		land = new LandingPage12(driver);
		land.launchApplication();
		locators.AboutArticle().sendKeys("This article is to test automation");
		locators.ArticleBody().sendKeys
		("Here i am testing what happens when tilte is blank, weather we are getting error msg or not");
		locators.PublishArticle().click();
		Assert.assertTrue(land.errorMsg().contains("can't be blank"));
	}

	@Test
	public void withoutArticleBody()

	{
		locators = new HomePage(driver);
		land = new LandingPage12(driver);
		land.launchApplication();
		locators.articleTitle().sendKeys("Automation Test");
		locators.AboutArticle().sendKeys("This article is to test automation");
		locators.PublishArticle().click();
		Assert.assertTrue(land.errorMsg().contains("can't be blank"));
	}

	@Test
	public void ArticleSubmission() throws InterruptedException

	{
		locators = new HomePage(driver);
		land = new LandingPage12(driver);
		land.launchApplication();
		locators.articleTitle().sendKeys("Automation test 122");
		locators.AboutArticle().sendKeys("This article is to test automation 1st");
		locators.ArticleBody().sendKeys(
				"Here I am testing what happens when tilte is blank, weather we are getting error msg or not");
		locators.ArticleTags().sendKeys("automationTest, anmol, anmoltiwary, testarticle");
		locators.PublishArticle().click();
	}

}
