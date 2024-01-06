package databaseconnect;
import java.sql.*;

public class DatabaseConnectGetSet {

    private final String userMySQL = "int_kjg_lt";
    private final String passwordMySQL = "Nestea55";
    private final String hostweb = "db4free.net";
    private final String host = "192.166.1.5";
    private final String port = "3306";
    private final String dbName = "ibiadata";
    private final String urlGetDBParameters = "autoReconnect=true&useSSL=false";
    //private final String strConnectionMySQLLocal = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?" + urlGetDBParameters;
    private final String strConnectionMySQLWeb = "jdbc:mysql://" + hostweb + ":" + port + "/" + dbName + "?" + urlGetDBParameters;

    private final String driverClassName = "com.mysql.cj.jdbc.Driver";

    private Connection connection;

    public DatabaseConnectGetSet() throws SQLException {
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(strConnectionMySQLWeb, userMySQL, passwordMySQL);

            if (connection == null) {
                String message = String.format("Could not connect to DB: %s", dbName);
                throw new SQLException(message);
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

//    public static void main(String[] args) {
//        try {
//            DatabaseConnectGetSet databaseConnect = new DatabaseConnectGetSet();
//            Connection connection = databaseConnect.getConnection();
//
//            if (connection != null) {
//                System.out.println("Connected to the database!");
//
//                // Example: Create a statement and execute a simple query
//                try (Statement statement = connection.createStatement()) {
//                    String query = "SELECT * FROM Users";
//                    ResultSet resultSet = statement.executeQuery(query);
//                    boolean usersFound = false;
//
//                    while (resultSet.next()) {
//                        usersFound = true;
//                        String uname = resultSet.getString("Uname");
//                        System.out.println("Username: " + uname);
//                    }
//
//                    if (!usersFound) {
//                        System.out.println("No users found in the Users table.");
//                    }
//                    // Process the result set or perform other operations
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//                // Close the connection when done
//                connection.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}


