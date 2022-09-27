package main.java.DAO;

import main.java.DTO.ProductoDTO;
import main.java.MysqlManager;
import org.apache.commons.csv.CSVRecord;

public class ProductoMysqlDAO implements ProductoDAO{

    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE productos("
                + "idproducto INT, "
                + "nombre VARCHAR(45),"
                + "valor FLOAT,"
                + "PRIMARY KEY(idproducto))";
        MysqlManager.getInstance().voidQuery(createTableQuery);
    }

    @Override
    public void insert(CSVRecord row) {
        Integer idProducto = Integer.valueOf(row.get("idProducto"));
        Float valor = Float.valueOf(row.get("valor"));
        String nombre = row.get("nombre");

        String createTableQuery = "INSERT INTO productos (idproducto, nombre, valor) VALUES ("
                + idProducto + ", "
                + "'" + nombre + "', "
                + valor + ") ";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }

    @Override
    public ProductoDTO getProductoQueMasRecaudo() {
        return null;
    }
}
