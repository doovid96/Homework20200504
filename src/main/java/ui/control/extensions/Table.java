package ui.control.extensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table extends BaseUiControlExtension{

	private By bodyLocator = By.tagName("tbody");
	private By rowLocator = By.tagName("tr");
	private WebElement tableElement = mappedElement;
	private By columnHeaderLocator = By.cssSelector("thead th");
	private List<WebElement> columnHeaders;
	private int rowCount;

	public Table(WebDriver driver, WebElement mappedElement) {
		super(driver, mappedElement);

		columnHeaders = this.tableElement.findElements(columnHeaderLocator);
	}

	public TableRow getRow(int ordinalRow) {

		List<WebElement> rowElements = getRowElements();

		return new TableRow(driver, columnHeaders, rowElements.get(ordinalRow - 1));
	}

	public int findCellByValue(String columnName, String findCellText) {

		for(int ordinalRow = 1;ordinalRow<=getRowCount();ordinalRow++) {

			TableRow row = getRow(ordinalRow);

			String cellText = row.getCell(columnName).getText();
			
			if(cellText.equals(findCellText)) {
				return ordinalRow;
			}				
		}

		throw new RuntimeException(new Exception("No row was found where column name is '" + columnName + "' and cellValue is '" + findCellText + "'"));
	}

	private int getRowCount() {
		if(rowCount == 0) {
			rowCount = getRowElements().size();
		}
		return rowCount;
	}

	private List<WebElement> getRowElements() {
		return getBodyElement().findElements(rowLocator);
	}

	private WebElement getBodyElement() {
		return mappedElement.findElement(bodyLocator);
	}
}
