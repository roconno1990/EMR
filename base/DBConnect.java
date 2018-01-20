package base;
		
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

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
    			connection =
    			    DriverManager.getConnection( "jdbc:mysql://localhost:3306/EMR",
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
