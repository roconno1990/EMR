package example;

import base.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class example
{
	public static void main(String[] argv)
	{
		DBConnect con = new DBConnect();
		DBBase data = new DBBase();
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		boolean success = con.initialise("root", "password");

		if( success )
		{
			System.out.println("Success!");
		}
		else
		{
			System.out.println("Awww maaaan");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", 1);
		map.put("UserName", "ryan");
		map.put("Password", "Blah");
		map.put("Role", "role");
		map.put("Creation_Time", data.getCurrentTimeStamp());
		
		data.insert(con.getConnection(), "user", map);

		Map<String, Object> updateFields = new HashMap<String, Object>();
		updateFields.put("username", "bryan");

		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("user_id", 1);
		data.update(con.getConnection(), "user", keyMap, updateFields);

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		rows = data.retrieve(con.getConnection(), "user", keyMap);
		for(int i = 0; i < rows.size(); i++)
		{
			for( Map.Entry<String, Object> entry : rows.get(i).entrySet() )
			{
				System.out.println("Column: " + entry.getKey() + " Value: " + entry.getValue());
			}
		}

		Map<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("user_id", 1);
		data.delete(con.getConnection(), "user", delMap);

		con.closeConnection();
	}
}


