package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import registration.model.product;

public class productDao {
	public static int registerProduct(product product) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO product" +
            "  ( name, barcode, colour, description) VALUES " +
            " ( ?, ?, ?, ?);";

        int result = 0;
        
        
        
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://localhost:3306/products?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=EET", "rooter", "1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //preparedStatement.setInt(1, i);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getBarcode());
            preparedStatement.setString(3, product.getColour());
            preparedStatement.setString(4, product.getDescription());
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }		
        return result;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
