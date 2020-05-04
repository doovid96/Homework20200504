package foundational;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.Action;
import framework.Logger;
import theInternet.pages.HoversPage;
import theInternet.tests.TheInternetTestBase;

public class lambdaTests extends TheInternetTestBase {

	@Test
	public void exceptionTest() {		
		try {
			Map<String, String> planes = new TreeMap<String, String>();
			planes.put("N753HF", "Piper Cherokee");
			planes.put("N951ER", "Cessna Skyhawk");
			planes.put("N147PT", "Grumman Cheetah");
			planes.put(null, "Null Pointer");

			for(Map.Entry<String,String> plane : planes.entrySet()) {
				Logger.writeInfo(plane.getValue());
			}
		}
		catch (NullPointerException ex) {
			Logger.writeInfo("Error: 1");
		}
		catch (ArithmeticException ex) {
			Logger.writeInfo("Error: 2");
		}
		catch (Exception ex) {
			Logger.writeInfo("Error: 3");
		}
	}
	
	@Test
	public void mapTest() {
		
		Map<String, String> planes = new HashMap<String, String>();
		planes.put("N753HF", "Piper Cherokee");
		planes.put("N951ER", "Cessna Skyhawk");
		planes.put("N951ER", "Grumman Cheetah");
		planes.put("N147PT", "Beech Bonanza");

		for(Map.Entry<String,String> plane : planes.entrySet()) {
			Logger.writeInfo(plane.getValue());
		}
	}
	
	@Test
	public void collectionTest() {

		String eleven = "Porsche 911";
		String twentyEight = "Porsche 928";
		String fourteen = "Porsche 914";
		
		Set<String> jerrysCars = new HashSet<String>();
		jerrysCars.add(eleven);
		
		Set<String> myCars = new HashSet<String>();
		myCars.addAll(jerrysCars);
		myCars.add(twentyEight);
		myCars.add(fourteen);
		
		jerrysCars.removeAll(myCars);
		
		Logger.writeInfo(jerrysCars.size());
	}
	
	@Test
	public void canDoAction() {
		
		Action.invoke(() -> Logger.writeInfo("this is the output of an anonymous method."));
	}
	
	@Test
	public void canNavigateWithPageObject() {
		
		HoversPage hoversPage = new HoversPage(driver, baseUrl);
		
		Action.invoke(() -> hoversPage.navigate());
		
		Assert.assertEquals(driver.getCurrentUrl(), hoversPage.getBaseUrl() + hoversPage.getPageUrl());
	}
}
