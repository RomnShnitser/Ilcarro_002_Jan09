package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

	public HelperUser(WebDriver wd) {
		super(wd);
	}

	// Login Block
	//============================================================================================================================
// Check, if user is loggedIn
	public boolean isLogged() {
		return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
	}

	// Logout
	public void logout() {
		mouseClick(By.xpath("//a[normalize-space()='Logout']"));
	}

	// Open Login Form
	public void openLoginForm() {
		mouseClick(By.xpath("//a[text()=' Log in ']"));
	}

	// Filling Login Form (with 'models' > 'User')
	public void fillingLoginForm(User userData) {
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	// Click Agree button when login form is done
	public void submitLogin() {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public boolean isLoggedSuccess() {
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
		return wd.findElement(By.cssSelector(".dialog-container")).getText().contains("success");
	}

	public void clickOkButtonOnLogin() {
		mouseClick(By.xpath("//button[@type='button']"));
	}

	// Registration Block
	//============================================================================================================================

	public void openRegistrationForm() {
		mouseClick(By.xpath("//a[.=' Sign up ']"));
	}

	public void fillingRegistrationForm(User userData) {
		type(By.xpath("//input[@id='name']"), userData.getName());
		type(By.xpath("//input[@id='lastName']"), userData.getLastName());
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	public void clickAgreeWithTermsOfUse() {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("document.querySelector('#terms-of-use').click();");
	}

	public void clickOkButtonOnRegistration() {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public boolean isRegisteredSuccess() {
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".mat-dialog-container"))));
		return wd.findElement(By.cssSelector(".mat-dialog-container")).getText().contains("success");
	}


}
