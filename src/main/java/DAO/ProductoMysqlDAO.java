package main.java.DAO;

import main.java.DTO.ProductoDTO;
import main.java.MysqlManager;

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
    public void insert(ProductoDTO productoDTO) {

    }

    @Override
    public ProductoDTO getProductoQueMasRecaudo() {
        return null;
    }
}
