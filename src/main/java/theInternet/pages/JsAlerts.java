package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;

public class JsAlerts extends PageBase {

	@FindBy(how=How.XPATH, using="//button[text()='Click for JS Alert']")
	WebElement AlertButton;

	@FindBy(how=How.XPATH, using="//button[text()='Click for JS Confirm']")
	WebElement ConfirmAlertButton;

	@FindBy(how=How.XPATH, using="//button[text()='Click for JS Prompt']")
	WebElement PromptButton;
	
	@FindBy(how=How.ID, using="result")
	WebElement ResultTextbox;
	
	public JsAlerts(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public JsAlerts navigate() {
		super.navigate("/javascript_alerts");

		return this;
	}

	public JsAlerts clickForJsAlert() {
		AlertButton.click();		

		return this;
	}

	public String closeAlertAndGetMessage() {
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		
		alert.accept();
		
		driver.switchTo().defaultContent();
		
		return alertText;
	}

	public JsAlerts clickForJsConfirm() {	
		ConfirmAlertButton.click();	
		
		return this;
	}
	
	public String confirmAlertAndGetMessage() {
		return closeAlertAndGetMessage();
	}

	public JsAlerts clickForJsPrompt() {
		PromptButton.click();	

		return this;
	}

	public String enterTextThenGetMessage(String promptText) {
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys(promptText);
		
		alert.accept();
		
		driver.switchTo().defaultContent();
		
		return ResultTextbox.getText();	
	}
}
