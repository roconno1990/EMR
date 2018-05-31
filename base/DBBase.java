package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBBase
{
	public void insert( Connection con, String tableName, Map<String, Object> fieldMap )
	{
		StringBuilder insert = new StringBuilder();
		PreparedStatement preparedStatement = null;

		try
		{
			insert.append("INSERT INTO ");
			insert.append(tableName.toUpperCase());
			insert.append("(");
	
			for( Map.Entry<String, Object> entry : fieldMap.entrySet() )
			{
				insert.append(entry.getKey().toUpperCase());
				insert.append(",");
			}
			insert = new StringBuilder(insert.subSequence(0, insert.length() - 1));
			insert.append(")");

			insert.append(" ").append("VALUES ");
			insert.append("(");
			for( int i = 0; i < fieldMap.size(); i++ )
			{
				insert.append("?");
				insert.append(",");
			}
			insert = new StringBuilder(insert.subSequence(0, insert.length() - 1));
			insert.append(")");

			preparedStatement = con.prepareStatement(insert.toString());
			int index = 1;
			for( Map.Entry<String, Object> entry : fieldMap.entrySet() )
			{
				preparedStatement.setObject(index, entry.getValue());
				index++;
			}

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch( SQLException e )
		{
			System.out.println("Exception caught inside insert!");
			e.printStackTrace();
		}
	}

	public void delete( Connection con, String tableName, Map<String, Object> fieldMap )
	{
		StringBuilder delete = new StringBuilder();
		PreparedStatement preparedStatement = null;

		try
		{
			delete.append("DELETE FROM ");
			delete.append(tableName.toUpperCase());
			delete.append(" ").append("WHERE ");
	
			for( Map.Entry<String, Object> entry : fieldMap.entrySet() )
			{
				delete.append(entry.getKey().toUpperCase()).append("=").append("'").append(entry.getValue()).append("'");
				delete.append(" AND ");
			}
			delete = new StringBuilder(delete.subSequence(0, delete.length() - 5));

			preparedStatement = con.prepareStatement(delete.toString());
			preparedStatement.executeUpdate();

			preparedStatement.close();
		}
		catch( SQLException e )
		{
			System.out.println("Exception caught insdie delete!");
			e.printStackTrace();
		}
	}

	public void update( Connection con,
			            String tableName,
			            Map<String, Object> keyMap,
			            Map<String, Object> updateFields )
	{
		StringBuilder update = new StringBuilder();
		PreparedStatement preparedStatement = null;

		try
		{
			update.append("UPDATE ");
			update.append(tableName.toUpperCase());
			update.append(" ").append("SET ");
	
			for( Map.Entry<String, Object> entry : updateFields.entrySet() )
			{
				update.append(entry.getKey().toUpperCase()).append("=").append("'").append(entry.getValue()).append("'");
				update.append(",");
			}
			update = new StringBuilder(update.subSequence(0, update.length() - 1));

			update.append(" ").append("WHERE ");
			for( Map.Entry<String, Object> entry : keyMap.entrySet() )
			{
				update.append(entry.getKey().toUpperCase()).append("=").append("'").append(entry.getValue()).append("'");
				update.append(" AND ");
			}
			update = new StringBuilder(update.subSequence(0, update.length() - 5));

			preparedStatement = con.prepareStatement(update.toString());
			preparedStatement.executeUpdate();

			preparedStatement.close();
		}
		catch( SQLException e )
		{
			System.out.println("Exception caught insdie delete!");
			e.printStackTrace();
		}
	}

	public List<Map<String, Object>> retrieve( Connection con,
			                                   String tableName,
			                                   Map<String, Object> keyMap )
	{
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		StringBuilder select = new StringBuilder();
		PreparedStatement preparedStatement = null;

		try
		{
			select.append("SELECT * FROM ");
			select.append(tableName.toUpperCase());
			select.append(" ").append("WHERE ");
	
			for( Map.Entry<String, Object> entry : keyMap.entrySet() )
			{
				select.append(entry.getKey().toUpperCase()).append("=").append("'").append(entry.getValue()).append("'");
				select.append(" AND ");
			}
			select = new StringBuilder(select.subSequence(0, select.length() - 5));

			preparedStatement = con.prepareStatement(select.toString());

			ResultSet rs;
			rs = preparedStatement.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();

			while( rs.next() )
			{
				Map<String, Object> row = new HashMap<String, Object>();
				for(int i = 1; i <= columnNum; i++)
				{
					row.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				dataList.add(row);
			}

			preparedStatement.close();
		}
		catch( SQLException e )
		{
			System.out.println("Exception caught inside retrieve!");
			e.printStackTrace();
		}

		return dataList;
	}

	public String getStringField( List<Map<String, Object>> fieldList,
			                      String fieldName)
	{
		String fieldValue = "";

		for(int i = 0; i < fieldList.size(); i++)
		{
			for( Map.Entry<String, Object> entry : fieldList.get(i).entrySet() )
			{
				if( fieldName.equals(entry.getKey().toUpperCase()) )
				{
					fieldValue = (String) entry.getValue();
					break;
				}
			}

			if( !fieldValue.equals("") )
			{
				break;
			}
		}

		return fieldValue;
	}

	public Integer getIntegerField( List<Map<String, Object>> fieldList,
                                    String fieldName)
	{
		Integer fieldValue = 0;
			
		for(int i = 0; i < fieldList.size(); i++)
		{
			for( Map.Entry<String, Object> entry : fieldList.get(i).entrySet() )
			{
				if( fieldName.equals(entry.getKey().toUpperCase()) )
				{
					fieldValue = (Integer) entry.getValue();
					break;
				}
			}
			
			if( !fieldValue.equals("") )
			{
				break;
			}
		}
			
			return fieldValue;
	}
	
	public Double getDoubleField( List<Map<String, Object>> fieldList,
                                   String fieldName)
	{
		Double fieldValue = 0.0;

		for(int i = 0; i < fieldList.size(); i++)
		{
			for( Map.Entry<String, Object> entry : fieldList.get(i).entrySet() )
			{
				if( fieldName.equals(entry.getKey().toUpperCase()) )
				{
					fieldValue = (Double) entry.getValue();
					break;
				}
			}

			if( !fieldValue.equals("") )
			{
				break;
			}
		}

		return fieldValue;
	}

	public java.sql.Timestamp getCurrentTimeStamp()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
}