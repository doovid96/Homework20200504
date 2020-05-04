package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageBase;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePage navigate() {
		super.navigate("");
		
		return this;
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
