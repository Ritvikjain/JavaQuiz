package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;


public class GetValues 
{
	public static Vector<Vector<String>> records;
	public static Vector<String> header;
	public static void getStudents()
	{
		records=new Vector<>();
		header=new Vector<>();
		String query="select * from student";
		Connection con=DBInfo.con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			while(res.next())
			{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
