package theInternet.tests;

import javax.swing.table.DefaultTableModel;

import framework.DatabaseUtility;

public class Queries {
	
	private DatabaseUtility databaseUtility;

	public Queries() {
	
		String url = "jdbc:mysql://127.0.0.1:3306/sakila";
		String userId = "root";
		String password = "1234";
				
		this.databaseUtility = new DatabaseUtility(url, userId, password);
	}
	
	public double getPaymentAmountForRentalId(int rentalId) {

		String sql = "SELECT amount FROM sakila.payment WHERE rental_id = " + rentalId + " LIMIT 1";
		
		return Double.valueOf(this.databaseUtility.executeScalar(sql));	
	}

	public DefaultTableModel getAllPayments() {
		
		String sql = "SELECT * FROM sakila.payment";

		return this.databaseUtility.executeQuery(sql);
	}	    
}
