package com.oceanview.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String url =
                        "jdbc:sqlserver://DESKTOP-F0G9G1H\\SQLEXPRESS:1433;" +
                                "databaseName=oceanview_db;" +
                                "integratedSecurity=true;" +
                                "encrypt=false;";

                connection = DriverManager.getConnection(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
