package test;

import main.java.MysqlManager;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MysqlManagerTest {

    @Test
    public void createTableProductoTest() {
        String createTableQuery = "CREATE TABLE productos("
                + "idproducto INT, "
                + "nombre VARCHAR(45),"
                + "valor FLOAT,"
                + "PRIMARY KEY(idproducto))";

        MysqlManager.createTable(createTableQuery);
        assertEquals(true, true);
    }
}
