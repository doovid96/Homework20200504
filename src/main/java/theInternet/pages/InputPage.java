package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageBase;

public class InputPage extends PageBase {

	public InputPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	By NumericInputLocator = By.tagName("input");
	
	public InputPage navigate() {
		super.navigate("/inputs");
		
		return this;
	}

	public InputPage setInputValue(int number) {
		getNumericInput(NumericInputLocator).setValue(number);

		return this;
	}

	public int getInputValue() {
		return getNumericInput(NumericInputLocator).getValue();
	}
}
