package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.*;


public class connection {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection con = null;
        PreparedStatement pstmt = null;

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin/database?user=root");
	String q1 = "insert into student values(?,?)";
	pstmt=con.prepareStatement(q1);
		System.out.println("Enter Name");
	String name = sc.next();
	System.out.println("Enter Password");
	String sal = sc.next();
	pstmt.setString(1, name);
	pstmt.setString(2, sal);

	int nori = pstmt.executeUpdate();
	System.out.println(nori+ " records inserted");
}
catch (Exception e)
{
	e.printStackTrace();
}

try
{
	if(con!=null)
	{
		con.close();
	}

	if(pstmt!=null)
	{
		pstmt.close();
	}
}

catch(Exception e)
{
	e.printStackTrace();
}
sc.close();
}




	}

