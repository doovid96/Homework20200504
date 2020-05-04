package framework;

import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		
		URL url = ClassLoader.getSystemResource("geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", url.getFile());
		
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("credentials_enable_service", false);
		options.addPreference("profile.password_manager_enabled", false);
		
		driver = new FirefoxDriver(options);
		
	}

}
