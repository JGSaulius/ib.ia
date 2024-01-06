//Here's how to install the MySQL Connector/J driver on Windows using platform-independent archives:
//Download the latest version of MySQL Connector/J: Go to the MySQL Connector/J download page: https://dev.mysql.com/doc/connector-j/en/connector-j-installing.html: https://dev.mysql.com/doc/connector-j/en/connector-j-installing.html
//Choose the platform-independent archive: Select the appropriate archive file, either .tar.gz or .zip, depending on your preference.
//Extract the archive: Download the chosen archive file and extract its contents to a convenient location on your system.
//Add the JAR file to your classpath: Modify your Java project's classpath to include the extracted .jar file from the MySQL Connector/J installation. You can do this manually or use your IDE's build configuration tools.
//Reference the driver in your code: Include the JDBC driver class in your Java code using the Class.forName(com.mysql.cj.jdbc.Driver) method to load the driver into memory before connecting to the database

//IntelliJ:
//        Right-click on your project.
//        Select "Open Module Settings" or press F4.
//        In the "Libraries" tab, click the "+" button to add a new library and select the MySQL JDBC driver JAR file.

package databaseconnect;

import java.sql.*;

public class DatabaseConnect {
    Connection cnx = null;
    public static Connection connect() throws SQLException {
        // JDBC URL, username, and password of MySQL server on db4free.net
        java.sql.Connection cnx = null;
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://db4free.net:3306/ibiadata?autoReconnect=true&useSSL=false";
        String username = "int_kjg_lt";
        String password = "Nestea55";
         // Load the MySQL JDBC driver
        try {
            Class.forName(driverClassName);
            cnx = DriverManager.getConnection(url, username, password);
            return cnx;
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) {
        try {
            // Establish a connection
            Connection connection = connect();
            if (connection != null) {
                System.out.println("Connected to the db4free.net database!");

                // Query the Users table
                String query = "SELECT Uname FROM Users";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    boolean usersFound = false;

                    // Iterate through the result set and print Uname column
                    while (resultSet.next()) {
                        usersFound = true;
                        String uname = resultSet.getString("Uname");
                        System.out.println("Username: " + uname);
                    }

                    if (!usersFound) {
                        System.out.println("No users found in the Users table.");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Close the connection when done
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}