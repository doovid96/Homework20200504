package demoqa.tests;

import java.util.Calendar;

import org.testng.annotations.Test;

public class CalendarTests extends DemoQaTestBase {

	@Test
	public void canSelectTodaysDateUsingApi() { 
	
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH, 5);  
		date.set(Calendar.DAY_OF_MONTH, 17);  
		date.set(Calendar.YEAR, 2021);  

		new DatePickerPage(driver, baseUrl)
		.navigate()
		.selectDateUsingApi(date);
	}
	
	@Test
	public void canSelectTodaysDate() { 
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH, 5);  
		date.set(Calendar.DAY_OF_MONTH, 17);  
		date.set(Calendar.YEAR, 2021);  

		new DatePickerPage(driver, baseUrl)
		.navigate()
		.selectDate(date);
	}
	
	@Test
	public void canExpandDatePicker() { 
		
		new DatePickerPage(driver, baseUrl)
		.navigate()
		.getDatePicker()
		.expandCalendar();
	}
}
