package theInternet.tests;

import javax.swing.table.DefaultTableModel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class databaseTest extends TheInternetTestBase {

	@Test
	public void canExecuteUsingTheStatementInterface() {

		double expectedPaymentAmount = 5.99;
		int rentalId = 78;
		
		double actualPaymentAmount = new Queries().getPaymentAmountForRentalId(rentalId );

		Assert.assertEquals(actualPaymentAmount, expectedPaymentAmount);
	}
	
	@Test
	public void canExecuteAndGetEntireRecordset() {

		double expectedRowCount = 16049;
		
		DefaultTableModel resultTable = new Queries().getAllPayments();
		
		Assert.assertEquals(resultTable.getRowCount(), expectedRowCount);
	}
}
