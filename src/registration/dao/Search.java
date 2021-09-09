package registration.dao;

import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import registration.model.product;

//import com.mysql.cj.xdevapi.Statement;

//import registration.model.product;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.*;

@WebServlet("/search")
public class Search extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String bar = req.getParameter("barcode");
		try 
		{
			 // create our mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/products?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=EET";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "rooter", "1234");
		      
		      String id = "1";
		      String query = "SELECT * FROM product WHERE barcode LIKE '%"+bar+"%'";
		      
		      java.sql.Statement st = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        
		        String name = rs.getString("name");
		        String barcode = rs.getString("barcode");
		        String colour = rs.getString("colour");
		        String description = rs.getString("description");
		        
		        
		        // print the results
		      
		        PrintWriter out = res.getWriter();
		        out.println(name +" "+barcode +" "+ colour +" "+ description);
		        
		      }
		      st.close();
		}
		catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}
}
