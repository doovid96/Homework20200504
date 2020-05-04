package demoqa.tests;

import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import framework.PageBase;
import ui.control.extensions.CalendarExtension;

public class DatePickerPage extends PageBase {

	@FindBy(how=How.ID, using="datepicker")
	WebElement dateTextbox;

	public DatePickerPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public void selectDate(Calendar desiredDate) {
		CalendarExtension calendar = getDatePicker();
		calendar.selectDate(desiredDate);
	}

	public void selectDateUsingApi(Calendar desiredDate) {
		CalendarExtension calendar = getDatePicker();
		calendar.selectDateWithApi(desiredDate);
	}

	public DatePickerPage navigate() {
		super.navigate("/datepicker");

		return this;
	}

	public CalendarExtension getDatePicker() {
		return new CalendarExtension(driver, dateTextbox);
	}
}
