package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;

public class NewWindowPage extends PageBase {

	private String previousPageWindowHandle;
	
	@FindBy(how=How.TAG_NAME, using="h3")
	WebElement pageTextElement;

	public NewWindowPage(WebDriver driver, String baseUrl, String previousPageWindowHandle) {
		super(driver, baseUrl);
		
		this.previousPageWindowHandle = previousPageWindowHandle;
	}

	public String GetTextThenCloseTabAndReturnToPrevious() {
		
		String text = pageTextElement.getText();
		
		super.closeTabAndSwitchTo(previousPageWindowHandle);
		
		return text;
	}
}
