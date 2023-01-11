package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
	WebDriver wd;

	// Constructor
	public HelperBase(WebDriver wd) {
		this.wd = wd;
	}

	// Methods
	//============================================================================================================================

	public boolean isElementPresent(By locator) {
		return wd.findElements(locator).size()>0;
	}

	public void type (By locator, String s) {
		WebElement element = wd.findElement(locator);

		element.click(); element.clear();
		element.sendKeys(s);
	}

	public void mouseClick(By locator) {
		wd.findElement(locator).click();
	}

	public String getText(By locator) {
		return wd.findElement(locator).getText();
	}
}
