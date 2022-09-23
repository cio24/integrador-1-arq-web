package main.java.DAO;

import main.java.MysqlManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductoMysqlDAO implements ProductoDAO{

    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE productos("
                + "idproducto INT, "
                + "nombre VARCHAR(45),"
                + "valor FLOAT,"
                + "PRIMARY KEY(idproducto))";
        MysqlManager.createTable(createTableQuery);
    }

    @Override
    public void getProductoQueMasRecaudo() {
    }
}
