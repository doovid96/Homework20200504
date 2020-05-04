package theInternet.pages;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import framework.Helpers;
import framework.PageBase;

public class JqueryMenuPage extends PageBase {

	public JqueryMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	private final String EXCEL_FILE = "menu.xls";
	private final String DOWNLOAD_FOLDER = "C:\\Users\\dtaylor\\Downloads\\";
	
	@FindBy(how=How.ID, using="menu")
	WebElement menuElement;

	public JqueryMenuPage ClickItemByMenuPath(String[] path) {

		for(int i = 0;i < path.length;i++) {

			String menuItemText = path[i];

			String menuItem = "//li[@class='ui-menu-item'][a[text()='" + menuItemText + "']]";

			menuElement = menuElement.findElement(By.xpath(menuItem));

			Duration duration = Duration.ofMillis(500);
			
			new Actions(driver)
			.moveToElement(menuElement)
			.pause(duration )
			.build()
			.perform();
			
			boolean isLastItemInPath = (i == path.length - 1);

			if(isLastItemInPath) {

				WebElement menuItemLink = menuElement.findElement(By.tagName("a"));

				menuItemLink.click();

				return this;
			}
		}

		throw new RuntimeException(new Exception("The menu path does not exist."));

	}

	public File getDownloadedFile() {
		String filePath = DOWNLOAD_FOLDER + EXCEL_FILE;

		Helpers.waitForFileExists(driver, filePath); 

		File downloadedFile = new File(filePath);

		return downloadedFile;
	}

	public JqueryMenuPage navigate() {
		super.navigate("/jqueryui/menu");
		return this;
	}

	public JqueryMenuPage deleteExcelFile() {
		String filePath = DOWNLOAD_FOLDER + EXCEL_FILE;
		
		File file = new File(filePath);
		
		file.delete();
		
		return this;
	}
}
