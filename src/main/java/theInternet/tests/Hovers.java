package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import theInternet.pages.HoversPage;

public class Hovers extends TheInternetTestBase {

	@Test(dataProvider="users")
	public void canHoverAndClickFirstTile(int index, String userName) {
		
		String expectedPageUrl = "/users/" + String.valueOf(index);

		String actualPageUrl = new HoversPage(driver, baseUrl)
				.navigate()
				.viewUserProfile(userName)
				.getPageUrl();

		Assert.assertEquals(actualPageUrl, expectedPageUrl);
	}

	@DataProvider(name="users")
	private Object[][] getUserNames() {
		return new Object[][] {
				{ 1, "user1" }, 
				{ 2, "user2" },
				{ 3, "user3" }
			};
	}	
}
