package theInternet.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.JqueryMenuPage;

public class JqueryMenu extends TheInternetTestBase {

	@Test
	public void canClickOnJqueryMenu() {	
		//arrange
		String expectedPageTitle = "menu.xls";

		//act
		File downloadedFile = new JqueryMenuPage(driver, baseUrl)
				.navigate()
				.deleteExcelFile()
				.ClickItemByMenuPath(new String[] { "Enabled", "Downloads", "Excel" })
				.getDownloadedFile();
						
		//assert
		Assert.assertEquals(downloadedFile.getName() , expectedPageTitle, "Could not navigate to the menu path"); 
	}	
}
