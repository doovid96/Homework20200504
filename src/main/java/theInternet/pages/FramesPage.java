package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageBase;

public class FramesPage extends PageBase {

	public FramesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public FramesPage navigate() {
		super.navigate("/nested_frames");

		return this;
	}
	
	String topFrame = "frame-top";
	String leftFrameName = "frame-left";
	String rightFrameName = "frame-right";
	String middleFrameName = "frame-middle";
	String bottomFrameName = "frame-bottom";
	
	public String getLeftFrameText() {
		driver.switchTo().frame(topFrame);
		driver.switchTo().frame(leftFrameName);
		return getFrameText();
	}
	
	public String getRightFrameText() {
		driver.switchTo().frame(topFrame);
		driver.switchTo().frame(rightFrameName);
		return getFrameText();
	}
	
	public String getMiddleFrameText() {
		driver.switchTo().frame(topFrame);
		driver.switchTo().frame(middleFrameName);
		return getFrameText();
	}
	
	public String getBottomLeftFrameText() {
		driver.switchTo().frame(bottomFrameName);
		return getFrameText();
	}

	private String getFrameText() {
	
		String frameText = driver.findElement(By.tagName("body")).getText();

		driver.switchTo().defaultContent();

		return frameText;
	}
}
