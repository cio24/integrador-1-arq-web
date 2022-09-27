package main.java.DAO;

import main.java.DTO.FacturaProductoDTO;
import main.java.MysqlManager;
import org.apache.commons.csv.CSVRecord;

public class FacturaProductoMysqlDAO implements DAO<FacturaProductoDTO> {
    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE facturasproductos("
                + "idfactura INT, "
                + "idproducto INT, "
                + "cantidad INT, "
                + "PRIMARY KEY(idfactura,idproducto), "
                + "FOREIGN KEY (idfactura) REFERENCES facturas(idfactura), "
                + "FOREIGN KEY (idproducto) REFERENCES productos(idproducto))";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }

    @Override
    public void insert(CSVRecord row) {
        Integer idfactura = Integer.valueOf(row.get("idFactura"));
        Integer idcliente = Integer.valueOf(row.get("idProducto"));
        Integer cantidad = Integer.valueOf(row.get("cantidad"));

        String createTableQuery = "INSERT INTO facturasproductos (idfactura, idproducto, cantidad) VALUES ("
                + idfactura + ", "
                + idcliente + ", "
                + cantidad + ") ";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }
}
