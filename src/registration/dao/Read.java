package registration.dao;

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

//import com.mysql.cj.xdevapi.Statement;

//import registration.model.product;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.*;


@WebServlet("/read")
public class Read extends HttpServlet {
	

	 
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		    try
		    {
		      // create our mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/products?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=EET";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "rooter", "1234");
		      
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM product";
	
		      // create the java statement
		      java.sql.Statement st = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
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