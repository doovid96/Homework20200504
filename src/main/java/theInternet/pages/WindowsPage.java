package theInternet.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;

public class WindowsPage extends PageBase {

	@FindBy(how=How.LINK_TEXT, using="Click Here")
	WebElement clickHereLink;

	public WindowsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public WindowsPage navigate() {
		super.navigate("/windows");
		
		return this;
	}

	public NewWindowPage clickHere() {
		String currentPageWindowHandle = driver.getWindowHandle();

		Set<String> openWindowHandlesBeforeClick = driver.getWindowHandles();

		clickHereLink.click();
		
		switchToNewTab(openWindowHandlesBeforeClick);
		
		return new NewWindowPage(driver, baseUrl, currentPageWindowHandle);
	}

	private void switchToNewTab(Set<String> openWindowHandlesBefore) {
		Set<String> openWindowHandlesAfter = driver.getWindowHandles();

		openWindowHandlesAfter.removeAll(openWindowHandlesBefore);
		
		if(openWindowHandlesAfter.size() == 0) {
			throw new RuntimeException(new Exception("New browser tab was not opened."));
		}
		
		if(openWindowHandlesAfter.size() > 1) {
			throw new RuntimeException(new Exception("More than one browser tab was opened."));
		}
		
		String mostRecentlyOpenedTab = openWindowHandlesAfter.iterator().next();
		
		driver.switchTo().window(mostRecentlyOpenedTab);		
	}
}
