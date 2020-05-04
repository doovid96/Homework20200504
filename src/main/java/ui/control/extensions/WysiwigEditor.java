package ui.control.extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwigEditor {

	private WebDriver driver;

	public WysiwigEditor(WebDriver driver, WebElement mappedElement) {
		this.driver = driver;
	}

	String editorFrameName = "mce_0_ifr";
	By editorTextArea = By.id("tinymce");
	
	public void clearThenEnterText(String textToEnter) {
		driver.switchTo().frame(editorFrameName);		
		
		driver.findElement(editorTextArea).clear();
		driver.findElement(editorTextArea).sendKeys(textToEnter);

		driver.switchTo().defaultContent();		
	}
	
	public String getText() {
		driver.switchTo().frame(editorFrameName);		

		String text = driver.findElement(editorTextArea).getText();

		driver.switchTo().defaultContent();
		
		return text;
	}
}
