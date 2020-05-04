package theInternet.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.Helpers;
import framework.PageBase;

public class DownloadPage extends PageBase {

	@FindBy(how=How.LINK_TEXT, using="some-file.txt")
	WebElement downloadLink;

	public DownloadPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public void downloadSomeFileTxt() {
		String folder = Helpers.getDownloadsFolder();
		
		Helpers.purgeFolder(new File(folder));
		
		downloadLink.click();
		
		Helpers.waitForFileExists(driver, folder + "/some-file.txt");
	}

	public DownloadPage navigate() {
		super.navigate("/download");
		
		return this;
	}
}
