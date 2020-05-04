package framework;

import java.io.File;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Helpers {

	public static void waitForFileExists(WebDriver driver, String fileName) {
		final File file = new File(fileName);

		Duration timeout = Duration.ofMinutes(1);
		Duration polling = Duration.ofMillis(200);

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout)
				.pollingEvery(polling);

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) { 
				return file.exists(); 
			}
		});	
	}

	public static void purgeFolder(File folder) {
		for (File file: folder.listFiles()) {
			if (file.isDirectory()) {
				purgeFolder(file);
			}
			file.delete();
		}
	}

	public static String getDownloadsFolder() {
		return System.getProperty("user.home") + "/Downloads/";
	}

	public static String getMonthName(int num) {
		//https://stackoverflow.com/questions/14832151/how-to-get-month-name-from-calendar

		String month = "";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11 ) {
			month = months[num];
		}
		return month;
	}

	public static String toStandardDateFormat(Calendar desiredDate) {
		SimpleDateFormat formatter = getStandardDateFormatter();
		String desiredDateFormatted = formatter.format(desiredDate.getTime());

		return desiredDateFormatted;
	}

	public static String toStandardDateFormatFromJavaFormat(String value) {
		SimpleDateFormat formatter = getStandardDateFormatter();
		Date date;
		
		try {
			date = getJavaDateFormatter().parse(value);
		} catch (ParseException e) {
			throw new RuntimeException("Cannot parse " + value + " to a date");
		}

		String desiredDateFormatted = formatter.format(date);

		return desiredDateFormatted;
	}

	public static SimpleDateFormat getStandardDateFormatter() {
		return new SimpleDateFormat("MM/dd/yyyy");
	}
	
	public static SimpleDateFormat getJavaDateFormatter() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	}
}
