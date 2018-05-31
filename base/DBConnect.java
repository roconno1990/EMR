package base;
		
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.http.auth.Credentials;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.storage.Storage;


public class DBConnect
{
	private Connection connection;

	/**
	 * Initialize connection to MySQL Database
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean initialise( String username, String password )
	{
		boolean success = true;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			success = false;
		}

        if( success )
        {
        	try
    		{     
        		String jdbcUrl = "jdbc:mysql://35.226.84.132:3306/EMR?user=root&password=password";
    			connection =
    			    DriverManager.getConnection( jdbcUrl,
    				                             username,
    				                             password );
    		}
    		catch (SQLException e)
    		{
    			System.out.println("Connection Failed! Check output console");
    			e.printStackTrace();
    			success = false;
    		}
        }

		return success;
	}

	/**
	 * Get the connection to run any database commands
	 * @return
	 */
	public Connection getConnection()
	{
		return connection;
	}

	/**
	 * Close the connection.
	 */
	public void closeConnection()
	{
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed to Close! Check output console");
			e.printStackTrace();
		}
		
	}
}
