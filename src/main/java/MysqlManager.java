package main.java;

import main.java.DAO.DAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class MysqlManager {

    private static MysqlManager instance = new MysqlManager();
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String uri = "jdbc:mysql://localhost:3306/integrador1";
    private static Connection conn;

    private MysqlManager(){};

    public static MysqlManager getInstance(){
        return instance;
    }

    public void openConnection(){
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection(uri, "root", "example");
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void voidQuery(String query){
        this.openConnection();

        try {
            Connection conn = DriverManager.getConnection(uri, "root", "example");
            conn.setAutoCommit(false);
            conn.prepareStatement(query).execute();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDataToTable(String path, DAO table){
            CSVParser parser = null;
            try {
                parser = CSVFormat.DEFAULT.withHeader().parse(new
                        FileReader(path));
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }

        for(CSVRecord row: parser) {
            table.insert(row);
        }
    }

    public ResultSet getDataQuery(String query){
        ResultSet rs = null;
        this.openConnection();
        try{

            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}
