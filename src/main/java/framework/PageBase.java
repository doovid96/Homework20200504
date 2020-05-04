package framework;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ui.control.extensions.CheckboxGroup;
import ui.control.extensions.NumericInput;
import ui.control.extensions.Slider;


public abstract class PageBase {
	protected WebDriver driver;
	protected String baseUrl;
	protected int pageLoadTimeoutSeconds;

	public PageBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;

		PageFactory.initElements(driver, this);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	protected void navigate(String url) {
		String pageUrl = new String(baseUrl + url);
		driver.navigate().to(pageUrl);		
	}

	protected Select getSelect(WebElement element) {
		return new Select(element);
	}

	protected CheckboxGroup getCheckboxGroup(By locator) {
		return new CheckboxGroup(driver, driver.findElement(locator));
	}

	protected Slider getSlider(By locator) {
		return new Slider(driver, driver.findElement(locator));
	}

	protected NumericInput getNumericInput(By locator) {
		return new NumericInput(driver, driver.findElement(locator));
	}

	protected void closeTabAndSwitchTo(String returnToWindowHandle) {
		driver.close();
		driver.switchTo().window(returnToWindowHandle);

		String currentWindowHandle = driver.getWindowHandle();

		if(currentWindowHandle.contentEquals(returnToWindowHandle)) {
			return;
		}

		throw new RuntimeException(new Exception("Did not switch to window with handle " + returnToWindowHandle));
	}

	protected void dragAndDrop(WebElement source, WebElement target) {

		new Actions(driver)
		.dragAndDrop(source, target)
		.build()
		.perform();
	}

	protected void doPageTransition(IAction action, int pageLoadTimeoutSeconds, boolean throwOnNonTransition) {

		long beforePageSignature = getCurrentPageSignature();						

		action.invoke();	

		Instant startTime = Instant.now();

		do {

			Duration elapsedTime = Duration.between(startTime, Instant.now());

			if(elapsedTime.getSeconds() > pageLoadTimeoutSeconds) {

				if(throwOnNonTransition) {
					throw new RuntimeException("Page transition did not occur within timeout of " + pageLoadTimeoutSeconds);
				}
			}
		} while (beforePageSignature == getCurrentPageSignature() 
				|| getCurrentPageSignature() == 0
				|| !isPageLoaded());
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	private boolean isPageLoaded() {
		String script = "return $.active === 0";
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		return (boolean)js.executeScript(script);			
	}
	
	private long getCurrentPageSignature() {
		String script = "return performance.timing.loadEventEnd";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		return (long)js.executeScript(script);			
	}
}
