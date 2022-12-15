package eng;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static Connection getConnection() {
        try {
//test
           // Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
            String url = "jdbc:mysql://localhost:3306";
            String databaseName = "Lab10";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url + "/" + databaseName, userName, password);
            System.out.println("Connected to database");
            return con;
        } catch (Exception e) {
            System.out.println("Couldn't connect to database");
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}