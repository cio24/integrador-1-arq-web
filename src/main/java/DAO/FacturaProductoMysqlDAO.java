package main.java.DAO;

import main.java.DTO.FacturaProductoDTO;
import main.java.MysqlManager;

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
    public void insert(FacturaProductoDTO facturaProductoDTO) {

    }
}
