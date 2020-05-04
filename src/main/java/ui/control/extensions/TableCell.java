package ui.control.extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableCell extends BaseUiControlExtension{
	public TableCell(WebDriver driver, WebElement mappedElement) {
		super(driver, mappedElement);
	}

	WebElement cellElement = mappedElement;
	
	public String getText() {
		return cellElement.getText();
	}

	public void click() {
		cellElement.click();		
	}
}
