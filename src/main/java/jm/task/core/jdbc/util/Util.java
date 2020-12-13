package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String userName = "root";
    private final static String password = "237942";
    private final static String connectionURL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private final static String JDBCDriver = "com.mysql.jdbc.Driver";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBCDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
