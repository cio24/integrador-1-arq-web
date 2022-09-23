package main.java;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlManager {

    public static void createTable(String createTableQuery){
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/integrador1";
        try {
            Connection conn = DriverManager.getConnection(uri, "root", "example");
            conn.setAutoCommit(false);
            conn.prepareStatement(createTableQuery).execute();
            conn.commit();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
