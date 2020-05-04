package ui.control.extensions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import framework.Helpers;
import framework.IsEqualTo;

//https://api.jqueryui.com/datepicker/
public class CalendarExtension extends BaseJQueryControlExtension {

	By monthLocator = By.cssSelector("span.ui-datepicker-month");

	By yearLocator = By.cssSelector("span.ui-datepicker-year");

	By headerLocator = By.cssSelector("div.ui-datepicker-header");

	By nextNavigationIcon = By.className("ui-datepicker-next");

	By previousNavigationIcon = By.className("ui-datepicker-previous");

	By calendarRootLocator = By.cssSelector("div[id='ui-datepicker-div']");

	public CalendarExtension(WebDriver driver, WebElement mappedElement) {
		super(driver, mappedElement);
	}

	public void selectDateWithApi(Calendar desiredDate) {

		String desiredDateFormatted = Helpers.toStandardDateFormat(desiredDate);

		executeJavaScriptOnMappedElement(".datepicker('setDate', '" + desiredDateFormatted + "')");
		
		waitForDateToSet(desiredDateFormatted);
	}

	public void selectDate(Calendar desiredDate) {

		expandCalendar();

		int desiredMonth = desiredDate.get(Calendar.MONTH);
		int desiredYear = desiredDate.get(Calendar.YEAR);
		int desiredDay = desiredDate.get(Calendar.DATE);
		String shortDayOfWeek = desiredDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
		
		navigateToMonthAndYear(desiredMonth, desiredYear);

		WebElement tableElement = getCalendarRootElement().findElement(By.tagName("table"));
		Table table = new Table(driver, tableElement);

		int foundRowNumber = table.findCellByValue(shortDayOfWeek, String.valueOf(desiredDay));
		table.getRow(foundRowNumber).getCell(shortDayOfWeek).click();	

		waitForExpanded(false);
	
		String desiredDateFormatted = Helpers.toStandardDateFormat(desiredDate);

		waitForDateToSet(desiredDateFormatted);
	}

	public String getValue() {
		String value = (String)executeJavaScriptOnMappedElement(".datepicker('getDate')");	
		String formattedValue = Helpers.toStandardDateFormatFromJavaFormat(value);
		
		return formattedValue;
	}

	public void expandCalendar() {
		executeJavaScriptOnMappedElement(".datepicker('show')");
		
		waitForExpanded(true);	
	}

	private void waitForExpanded(boolean isExpanded) {

//		String style = isExpanded ? "display: none;" : "display: block;";

//		String styleAttribute = getCalendarRootElement().getAttribute("style");
//				
//		new FluentWait<WebDriver>(driver)
//		.withTimeout(Duration.ofSeconds(5))
//		.pollingEvery(Duration.ofMillis(200))
//		.until(ExpectedConditions.attributeContains(getCalendarRootElement(), "style", style));			
	}

	private WebElement getCalendarRootElement() {
		ArrayList<?> returnValue = (ArrayList<?>)executeJavaScriptOnMappedElement(".datepicker('widget')");
		
		if(returnValue.size() == 0) {
			throw new RuntimeException("Could not get datepicker Widget.");
		}
		
		return (WebElement) returnValue.get(0);
	}

	private void navigateToMonthAndYear(int desiredMonth, int desiredYear) {
		while(getCurrentYear() < desiredYear) {
			clickNextNavigationIcon();	
		}	

		while(getCurrentYear() > desiredYear) {
			clickPreviousNavigationIcon();
		}	

		while(getCurrentMonth() < desiredMonth) {
			clickNextNavigationIcon();	
		}	

		while(getCurrentMonth() > desiredMonth) {
			clickPreviousNavigationIcon();
		}			
	}

	private void clickPreviousNavigationIcon() {
		getHeaderElement().findElement(previousNavigationIcon).click();		
	}

	private void clickNextNavigationIcon() {
		getHeaderElement().findElement(nextNavigationIcon).click();		
	}

	private int getCurrentMonth() {

		WebElement element = getHeaderElement().findElement(monthLocator);
		String elementValue = element.getAttribute("value");
		return Integer.valueOf(elementValue);
	}

	private int getCurrentYear() {

		WebElement element = getHeaderElement().findElement(yearLocator);
		String elementValue = element.getAttribute("value");
		return Integer.valueOf(elementValue);
	}

	private WebElement getHeaderElement() {
		return getCalendarRootElement().findElement(headerLocator);
	}
	
	private void waitForDateToSet(String desiredDateFormatted) {
		new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(5))
		.pollingEvery(Duration.ofMillis(200))
		.until(new IsEqualTo(desiredDateFormatted, getValue()));		
	}
}
