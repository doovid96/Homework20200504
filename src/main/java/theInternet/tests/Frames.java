package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theInternet.pages.FramesPage;

public class Frames extends TheInternetTestBase {

	@Test
	public void canGetTextFromFrame( ) {
		
		String expectedLeftFrameText = "LEFT";
		String expectedMiddleFrameText = "MIDDLE";
		String expectedRightFrameText = "RIGHT";
		String expectedBottomFrameText = "BOTTOM";
		
		FramesPage framesPage = new FramesPage(driver, baseUrl)
				.navigate();
		
		String actualLeftFrameText = framesPage.getLeftFrameText();
		String actualMiddleFrameText = framesPage.getMiddleFrameText();
		String actualRightFrameText = framesPage.getRightFrameText();
		String actualBottomFrameText = framesPage.getBottomLeftFrameText();
		
		Assert.assertEquals(actualLeftFrameText, expectedLeftFrameText);
		Assert.assertEquals(actualMiddleFrameText, expectedMiddleFrameText);
		Assert.assertEquals(actualRightFrameText, expectedRightFrameText);
		Assert.assertEquals(actualBottomFrameText, expectedBottomFrameText);
	}
}
