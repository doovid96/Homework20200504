package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.JsAlerts;

public class JavascriptAlerts extends TheInternetTestBase {
	
	@Test
	public void canHandleAlert() {
		
		String expectedMessage = "I am a JS Alert";
		
		String actualMessage = new JsAlerts(driver, baseUrl)
				.navigate()
				.clickForJsAlert()
				.closeAlertAndGetMessage();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test
	public void canHandleConfirmAlert() {
		
		String expectedMessage = "I am a JS Confirm";
		
		String actualMessage = new JsAlerts(driver, baseUrl)
				.navigate()
				.clickForJsConfirm()
				.confirmAlertAndGetMessage();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}	
	
	@Test
	public void canHandleJsPrompt() {
		
		String alertTextToEnter = "this is static text";
		String expectedMessage = "You entered: " + alertTextToEnter;
		
		String actualMessage = new JsAlerts(driver, baseUrl)
				.navigate()
				.clickForJsPrompt()
				.enterTextThenGetMessage(alertTextToEnter);
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
