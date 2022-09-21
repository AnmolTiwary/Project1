package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import Initialization.driverInt;
import locatorAndContrains.HomePage;
import locatorAndContrains.LandingPage12;

public class artCommTest extends driverInt {
	HomePage locators;
	LandingPage12 land;

	@Test
	public void favTest() throws InterruptedException {
		locators = new HomePage(driver);
		land = new LandingPage12(driver);
		land.loginApplication("anmol@abc.com", "anmoltiwary");
		locators.Globalfeed().click();
		locators.favButton().click();
		String favArticleTitle = locators.favArtTitle().getText();
		locators.userProfile().click();
		locators.Favarticle().click();
		Thread.sleep(5000);

		String listName = locators.Favlist().getText();
		Assert.assertTrue(listName.contains(favArticleTitle));
	}

	@Test
	public void commenttest() throws InterruptedException {
		locators = new HomePage(driver);
		land = new LandingPage12(driver);
		land.loginApplication("anmol@abc.com", "anmoltiwary");
		locators.Globalfeed().click();
		locators.favArtTitle().click();
		locators.Comment().sendKeys("comment1");
		locators.Submit().click();
		Thread.sleep(5000);
		String comment = locators.commentCheck().getText();
		Assert.assertEquals(comment, "comment1");

	}

}
