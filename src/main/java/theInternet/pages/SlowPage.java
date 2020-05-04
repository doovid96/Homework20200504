package theInternet.pages;

import org.openqa.selenium.WebDriver;

import framework.PageBase;

public class SlowPage extends PageBase {

	public SlowPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.pageLoadTimeoutSeconds = 31;
	}

	public SlowPage navigate() {
		
		doPageTransition(() -> super.navigate("/slow"), this.pageLoadTimeoutSeconds, true);
		
		return this;
	}
}
