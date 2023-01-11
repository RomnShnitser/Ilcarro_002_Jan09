package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
	WebDriver wd;
	HelperUser user;

	public HelperUser getUser() {
		return user;
	}

	public void initialization() {
		wd = new ChromeDriver();

		wd.manage().window().maximize();
		wd.navigate().to("https://ilcarro.web.app");
		wd.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		user = new HelperUser(wd);
	}

	public void stop() {
		wd.quit();
	}
}
