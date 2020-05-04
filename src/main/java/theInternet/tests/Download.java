package theInternet.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.Helpers;
import theInternet.pages.DownloadPage;

public class Download extends TheInternetTestBase {

	@Test
	public void canDownloadTextFile() {
		
		String expectedDownloadedFile = "some-file.txt";
		String folder = Helpers.getDownloadsFolder();
		Path filePath = Paths.get(folder, expectedDownloadedFile); 
			
		new DownloadPage(driver, baseUrl)
			.navigate()
			.downloadSomeFileTxt();
		
		Assert.assertTrue(filePath.toFile().exists());
	}
}
