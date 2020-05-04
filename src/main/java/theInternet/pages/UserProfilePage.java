package theInternet.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import framework.PageBase;

public class UserProfilePage extends PageBase implements IDefineUserProfiles {

	public UserProfilePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String getPageUrl() {

		try {
			URL fullUrl = new URL(driver.getCurrentUrl());
			return fullUrl.getPath();
		} catch (MalformedURLException e) {
			throw new RuntimeException("could not get the url");
		}
	}
}
