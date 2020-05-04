package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class IsEqualTo implements ExpectedCondition<Boolean> {

	private String value1;
	private String value2;

	public IsEqualTo(String value1, String value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	public Boolean apply(WebDriver driver) {
		return value1.equals(value2);
	}
}
