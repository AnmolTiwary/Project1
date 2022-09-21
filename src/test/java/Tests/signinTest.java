package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import Initialization.driverInt;
import locatorAndContrains.LandingPage12;

public class signinTest extends driverInt {
	LandingPage12 login;

	@Test
	public void blankEmail() {
		login = new LandingPage12(driver);
		login.loginApplication(" ", "anmoltiwary");
		Assert.assertTrue(login.errorMsg().equalsIgnoreCase("email can't be blank"));
	}

	@Test
	public void blankpassword() {

		login = new LandingPage12(driver);
		login.loginApplication("anmol@abc.com", " ");
		Assert.assertTrue(login.errorMsg().equalsIgnoreCase("password can't be blank"));
	}

	@Test
	public void invalidemail() {
		login = new LandingPage12(driver);
		login.loginApplication("anmol@wbc.com", "anmoltiwary");
		Assert.assertTrue(login.errorMsg().equalsIgnoreCase("email or password is invalid"));
	}

	@Test
	public void invalidpassword() {

		login = new LandingPage12(driver);
		login.loginApplication("anmol@abc.com", "anmoltiwary12");
		Assert.assertTrue(login.errorMsg().equalsIgnoreCase("email or password is invalid"));
	}

	@Test
	public void Login() {
		login = new LandingPage12(driver);
		login.loginApplication("anmol@abc.com", "anmoltiwary");
		login.Logout();
	}

}
