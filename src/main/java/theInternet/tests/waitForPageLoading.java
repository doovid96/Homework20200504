package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.RedirectorPage;
import theInternet.pages.SlowPage;

public class waitForPageLoading extends TheInternetTestBase {

	@Test
	public void canWaitForPageTransition() {
		
		String expectedUrl = baseUrl + "/status_codes";
		
		String actualUrl = new RedirectorPage(driver, baseUrl)
				.navigate()
				.clickHereLink()
				.getCurrentUrl();	
		
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	
	@Test
	public void canWaitForSlowPage() {
		
		String expectedUrl = baseUrl + "/slow";

		String actualUrl = new SlowPage(driver, baseUrl)
				.navigate()
				.getCurrentUrl();	
		
		Assert.assertEquals(actualUrl, expectedUrl);		
	}
}
