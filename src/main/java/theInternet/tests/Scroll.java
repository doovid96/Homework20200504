package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.InfiniteScroll;

public class Scroll extends TheInternetTestBase {

	@Test
	public void canScrollAndGetParagraphText() {

		String paragraphText = new InfiniteScroll(driver, baseUrl)
				.navigate()
				.scrollUntilNewParagraphLoaded()
				.getLastParagraphText();

		Assert.assertNotNull(paragraphText);
	}
}
