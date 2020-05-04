package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.WindowsPage;

public class Windows extends TheInternetTestBase {

	@Test
	public void canClickNewTabAndGetText() {
		
		String expectedText = "New Window";
		
		String actualText = new WindowsPage(driver, baseUrl)
				.navigate()
				.clickHere()
				.GetTextThenCloseTabAndReturnToPrevious();
		
		Assert.assertEquals(actualText, expectedText);
	}
}
