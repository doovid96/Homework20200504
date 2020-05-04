package ui.control.extensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseJQueryControlExtension extends BaseUiControlExtension {

	public BaseJQueryControlExtension(WebDriver driver, WebElement mappedElement) {
		super(driver, mappedElement);
	}

	protected Object executeJavaScriptOnMappedElement(String scriptPredicate) {

		String script = "return $(arguments[0])" + scriptPredicate;
				
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		return js.executeScript(script , mappedElement);		
	}
}
