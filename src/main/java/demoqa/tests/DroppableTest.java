package demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import demoqa.pages.Droppable;

public class DroppableTest extends DemoQaTestBase {

	@Test
	public void canDragAndDrop() {
		
		boolean isDropped = new Droppable(driver, baseUrl)
		.navigate()
		.dragToTarget()
		.getIsDropped();
		
		Assert.assertTrue(isDropped, "drag and drop failed");
	}
}
