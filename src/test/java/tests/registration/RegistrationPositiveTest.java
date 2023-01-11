package tests.registration;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPositiveTest extends tests.TestBase {
	@BeforeMethod
	public void precondition() {
		if (app.getUser().isLogged()) {
			app.getUser().logout();
		}
	}

	@Test
	public void registrationSuccess() {
		int a = (int) (System.currentTimeMillis() / 1000) % 3600;

		String name = "Jack";
		String lastName = "Ramble";
		String email = "jack" + a + "@gmail.com";
		String password = "$ABCdef12345";

		User userData = new User()
				.withName(name)
				.withLastName(lastName)
				.withEmail(email)
				.withPassword(password);

		app.getUser().openRegistrationForm();
		app.getUser().fillingRegistrationForm(userData);
		app.getUser().clickAgreeWithTermsOfUse();
		app.getUser().clickOkButtonOnRegistration();

		Assert.assertTrue(app.getUser().isRegisteredSuccess());
	}

	@AfterMethod
	public void postCondition() {
		app.getUser().mouseClick(By.xpath("//button[@type='button']"));
	}
}
