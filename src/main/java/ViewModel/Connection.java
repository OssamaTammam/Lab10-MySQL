package ViewModel;

import java.sql.DriverManager;

public abstract class Connection {
    public static java.sql.Connection getConnection() {
        try {

            // Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
            String url = "jdbc:mysql://localhost:3306";
            String databaseName = "Lab10";
            String userName = "root";
            String password = "";
            java.sql.Connection con = DriverManager.getConnection(url + "/" + databaseName, userName, password);
            System.out.println("Connected to database");
            return con;
        } catch (Exception e) {
            System.out.println("Couldn't connect to database");
        }
        return null;
    }
}
