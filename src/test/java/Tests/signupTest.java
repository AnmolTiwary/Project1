package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import Initialization.driverInt;
import locatorAndContrains.LandingPage12;

public class signupTest extends driverInt {
	LandingPage12 Signup;

	@Test
	public void usernameTest() {
		Signup = new LandingPage12(driver);
		Signup.signupApplication(" ", "anmol@abc.com", "anmoltiwary");
		AssertJUnit.assertTrue(Signup.errorMsg().equalsIgnoreCase("username can't be blank"));
	}

	@Test
	public void EmailTest() throws IOException {
		Signup = new LandingPage12(driver);
		Signup.signupApplication("Anmol Tiwary", " ", "anmoltiwary");
		AssertJUnit.assertTrue(Signup.errorMsg().equalsIgnoreCase("email can't be blank"));
	}

	@Test
	public void passwordTest() throws IOException {
		Signup = new LandingPage12(driver);
		Signup.signupApplication("Anmol Tiwary", "anmol@abc.com", " ");
		AssertJUnit.assertTrue(Signup.errorMsg().equalsIgnoreCase("password can't be blank"));
	}

	@Test
	public void Signup() throws IOException {
		Signup = new LandingPage12(driver);
		Signup.signupApplication("Anmol Tiwary", "anmol@abc.com", "anmoltiwary");
	}

	@Test
	public void alreadyRegisteredEmail() throws IOException {
		Signup = new LandingPage12(driver);
		Signup.signupApplication("Anmol Tiwary ", "anmol@abc.com", "anmoltiwary3354");
		AssertJUnit.assertTrue(Signup.errorMsg().equalsIgnoreCase("email has already been taken"));
	}

	@Test
	public void preRegisteredUsername() throws IOException {
		Signup = new LandingPage12(driver);
		Signup.signupApplication("Anmol Tiwary", "anmol143@abc.com", "anmoltiwary");
		AssertJUnit.assertTrue(Signup.errorMsg().equalsIgnoreCase("username has already been taken"));

	}

}
