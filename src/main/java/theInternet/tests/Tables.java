package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.TablesPage;

public class Tables extends TheInternetTestBase {

	String userEmailAddress = "jdoe@hotmail.com";
	String expectedText = "$100.00";
	
	@Test
	public void canGetTable1CellContents() {
				
		String actualText = new TablesPage(driver, baseUrl)
				.navigate()
				.getAmountDueForUserTable1(userEmailAddress);
		
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test
	public void canGetTable2CellContents() {
		
		String actualText = new TablesPage(driver, baseUrl)
				.navigate()
				.getAmountDueForUserTable2(userEmailAddress);
		
		Assert.assertEquals(actualText, expectedText);
	}
}
