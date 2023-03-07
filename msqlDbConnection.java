package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class msqlDbConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws ClassNotFoundException {
        String connectionUrl =
                "jdbc:sqlserver://DEL-H0SD2B3:1433;"
                        + "database=master;"
                        + "user=chuck;"
                        + "password=Anuj@1009;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";


        ResultSet resultSet = null;
       // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 * from PORTFOLIO_SCOPE";
            resultSet = statement.executeQuery(selectSql);
            int index=1;
            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(index+") "+resultSet.getString(1) );
                index++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}