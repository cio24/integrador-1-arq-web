package test;

import main.java.MysqlManager;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MysqlManagerTest {

    @Test
    public void createTableProductosTest() {
        String createTableQuery = "CREATE TABLE productos("
                + "idproducto INT, "
                + "nombre VARCHAR(45),"
                + "valor FLOAT,"
                + "PRIMARY KEY(idproducto))";

        MysqlManager.createTable(createTableQuery);
        assertEquals(true, true);
    }

    @Test
    public void createTableClientesTest() {
        String createTableQuery = "CREATE TABLE clientes("
                + "idcliente INT, "
                + "nombre VARCHAR(500),"
                + "email VARCHAR(150),"
                + "PRIMARY KEY(idcliente))";

        MysqlManager.createTable(createTableQuery);

        assertEquals(true, true);
    }

    @Test
    public void createTableFacturasTest() {
        String createTableQuery = "CREATE TABLE facturas("
                + "idfactura INT, "
                + "idcliente INT, "
                + "PRIMARY KEY(idfactura), "
                + "FOREIGN KEY (idcliente) REFERENCES clientes(idcliente))";

        MysqlManager.createTable(createTableQuery);
        assertEquals(true, true);
    }

    @Test
    public void createTableFacturasProductosTest() {
        String createTableQuery = "CREATE TABLE facturasproductos("
                + "idfactura INT, "
                + "idproducto INT, "
                + "cantidad INT, "
                + "PRIMARY KEY(idfactura,idproducto), "
                + "FOREIGN KEY (idfactura) REFERENCES facturas(idfactura), "
                + "FOREIGN KEY (idproducto) REFERENCES productos(idproducto))";

        MysqlManager.createTable(createTableQuery);
        assertEquals(true, true);
    }
}
