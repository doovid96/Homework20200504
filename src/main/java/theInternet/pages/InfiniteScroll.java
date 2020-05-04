package theInternet.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Logger;
import framework.PageBase;

public class InfiniteScroll extends PageBase {

	public InfiniteScroll(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public InfiniteScroll navigate() {
		super.navigate("/infinite_scroll");

		waitForPageLoading();

		return this;
	}

	public InfiniteScroll scrollUntilNewParagraphLoaded() {

		List<WebElement> paragraphs = getParagraphs();
		int initialParagraphsCount = paragraphs.size();
		int limit = 10;
		int i = 0;

		do
		{
			Logger.writeInfo(String.valueOf(paragraphs.size() + " paragraphs found. Scrolling now ..."));
			scrollDownOnce();	

			waitForPageLoading();

			paragraphs = getParagraphs(); 
		}while(paragraphs.size() < initialParagraphsCount && i++ < limit);

		Logger.writeInfo(String.valueOf(paragraphs.size() + " paragraphs found."));

		return this;
	}

	public String getLastParagraphText() {
		List<WebElement> paragraphs = getParagraphs(); 

		return paragraphs.get(paragraphs.size() - 1).getText();
	}

	private void scrollDownOnce() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, window.innerHeight)");	
	}

	private List<WebElement> getParagraphs() {
		return driver.findElements(By.className("jscroll-added"));
	}

	private void waitForPageLoading() {
		Duration interval = Duration.ofMillis(100);
		
		new WebDriverWait(driver, 10)
		.pollingEvery(interval )
		.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Loading...')]"))));	
	}
}
