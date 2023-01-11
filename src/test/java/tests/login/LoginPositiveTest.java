package tests.login;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPositiveTest extends tests.TestBase {
	@BeforeMethod
	public void precondition() {
		if (app.getUser().isLogged()) {
			app.getUser().logout();
		}
	}

	@Test
	public void loginSuccess() {
		String email = "romn.shnitser@gmail.com";
		String password = "$Qwerty12345";

		User userData = new User()
				.withEmail(email)
				.withPassword(password);

		app.getUser().openLoginForm();
		app.getUser().fillingLoginForm(userData);
		app.getUser().submitLogin();
		Assert.assertTrue(app.getUser().isLoggedSuccess());
	}

	@AfterMethod
	public void postCondition() {
		app.getUser().clickOkButtonOnLogin();
	}
}
