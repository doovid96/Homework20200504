package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;

public class Droppable extends PageBase {

	@FindBy(how = How.ID, using= "draggable")
	WebElement draggable;

	@FindBy(how = How.ID, using= "droppable")
	WebElement droppable;

	public Droppable(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);	
	}

	public Droppable navigate() {
		super.navigate("/droppable");

		return this;
	}

	public Droppable dragToTarget() {

		super.dragAndDrop(draggable, droppable);

		return this;
	}

	public boolean getIsDropped() {
		
		String droppableText = droppable.findElement(By.tagName("p")).getText();

		return droppableText.equalsIgnoreCase("dropped!");
	}
}
