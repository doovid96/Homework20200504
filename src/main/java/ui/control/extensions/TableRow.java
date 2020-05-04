package ui.control.extensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableRow extends BaseUiControlExtension{

	private WebElement rowElement = mappedElement;
	private By cellLocator = By.tagName("td");
	private List<WebElement> columnHeaders;

	public TableRow(WebDriver driver, List<WebElement> columnHeaders, WebElement rowElement) {
		super(driver, rowElement);

		this.columnHeaders = columnHeaders;
	}

	public TableCell getCell(String columnName) {
		List<WebElement> cellElements = getCellElements();

		int columnIndex = getColumnIndexForColumnName(columnName);
		
		return new TableCell(driver, cellElements.get(columnIndex));
	}

	private int getColumnIndexForColumnName(String columnName) {
		
		int index = -1;
		
		for(WebElement columnHeader : columnHeaders) {		
			
			index++;
			
			if(columnHeader.getText().equals(columnName)) {
				return index;
			}
		}
		
		throw new RuntimeException(new Exception("The row does not contain a column named '" + columnName +"'"));
	}

	private List<WebElement> getCellElements() {
		return rowElement.findElements(cellLocator);
	}
}
