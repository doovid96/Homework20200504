package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;

public class RedirectorPage extends PageBase {

	@FindBy(how=How.ID, using="redirect")
	WebElement here;

	public RedirectorPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		
		this.pageLoadTimeoutSeconds = 2;
	}

	public RedirectorPage navigate() {
		super.navigate("/redirector");	
		
		return this;
	}

	public StatusCodes clickHereLink() {
		
		doPageTransition(() -> here.click(), this.pageLoadTimeoutSeconds, true);
		
		return new StatusCodes(driver, baseUrl);
	}
}
