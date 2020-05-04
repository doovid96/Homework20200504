package theInternet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import framework.PageBase;

public class HoversPage extends PageBase {

	private String pageUrl;

	public String getPageUrl() {
		return pageUrl;
	}

	public HoversPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		
		this.pageUrl = "/hovers";
	}

	public IDefineUserProfiles viewUserProfile(String userName) {
		WebElement hoverTile = driver.findElement(By.xpath("//h5[text()='name: " + userName + "']//ancestor::div[@class='figure']"));

		new Actions(driver)
		.moveToElement(hoverTile)
		.build()
		.perform();

		waitForVisibleThenClickViewProfileLink(hoverTile);
		
		return new UserProfilePage(driver, baseUrl);
	}

	public HoversPage navigate() {
		super.navigate(pageUrl);

		return this;
	}

	private void waitForVisibleThenClickViewProfileLink(WebElement hoverTile) {
		Duration timeout = Duration.ofSeconds(10);
		Duration interval = Duration.ofMillis(200);
		
		WebElement viewProfileLink = hoverTile.findElement(By.tagName("a"));
		
		new FluentWait<WebDriver>(driver)
		.withTimeout(timeout)
		.pollingEvery(interval)
		.until(ExpectedConditions.visibilityOf(viewProfileLink));		
		
		viewProfileLink.click();
	}
}
