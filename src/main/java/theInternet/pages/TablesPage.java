package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageBase;
import ui.control.extensions.Table;

public class TablesPage extends PageBase {

	@FindBy(how=How.ID, using="table1")
	WebElement example1TableElement;

	@FindBy(how=How.ID, using="table2")
	WebElement example2TableElement;
	
	public TablesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public TablesPage navigate() {
		super.navigate("/tables");

		return this;
	}

	public String getAmountDueForUserTable1(String emailAddress) {

		return getAmountDueForUser(emailAddress, example1TableElement);
	}
	
	public String getAmountDueForUserTable2(String emailAddress) {

		return getAmountDueForUser(emailAddress, example2TableElement);
	}
	
	private String getAmountDueForUser(String emailAddress, WebElement tableElement) {

		Table table = new Table(driver, tableElement);
		
		int foundRow = table.findCellByValue(ColumnNames.EMAIL, emailAddress);

		String amountDue = table.getRow(foundRow).getCell(ColumnNames.DUE).getText();

		return amountDue;
	}

	private class ColumnNames
	{
		public static final String EMAIL = "Email"; 
		public static final String DUE = "Due"; 
	}
}
