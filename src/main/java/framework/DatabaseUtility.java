package framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

//https://stackoverflow.com/questions/1340283/datatable-equivalent-in-java
public class DatabaseUtility {
	private Connection connection = null;
	private ResultSet resultSet = null;
	private String password;
	private String userId;
	private String url;

	public DatabaseUtility(String url, String userId, String password) {

		this.url = url;
		this.userId = userId;
		this.password = password;		
	}

	public String executeScalar(String sql) {

		String returnValue;

		try {
			connection = getDatabaseConnection();

			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			resultSet.next();

			returnValue = resultSet.getString(1);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException("Error closing connection: " + e.getMessage());
				}
				finally {

				}
			}
		}

		return returnValue;
	}

	public DefaultTableModel executeQuery(String sql) {

		DefaultTableModel resultTable = new DefaultTableModel();

		try {
			connection = getDatabaseConnection();

			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			ResultSetMetaData metaData = resultSet.getMetaData();
			int totalColumn = metaData.getColumnCount();
			Object[] dataRow = new Object[totalColumn];

			if(resultSet != null)
			{
				for(int i = 1;i <= totalColumn;i++)
				{
					resultTable.addColumn(metaData.getColumnName(i));
				}
				while(resultSet.next())
				{
					for(int i = 1;i <= totalColumn;i++)
					{
						dataRow[i - 1] = resultSet.getObject(i);
					}
					resultTable.addRow(dataRow);
				}
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException("Error closing connection: " + e.getMessage());
				}
			}
		}

		return resultTable;
	}

	private Connection getDatabaseConnection() throws Exception {
		connection = DriverManager.getConnection(url, userId, password);

		if (connection == null) {
			throw new Exception("Failed to make database connection!");
		}	

		return connection;
	}

}