package main.java.DAO;

import main.java.DTO.FacturaDTO;
import main.java.MysqlManager;

public class FacturaMysqlDAO implements DAO<FacturaDTO> {
    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE facturas("
                + "idfactura INT, "
                + "idcliente INT, "
                + "PRIMARY KEY(idfactura), "
                + "FOREIGN KEY (idcliente) REFERENCES clientes(idcliente))";
        MysqlManager.getInstance().voidQuery(createTableQuery);
    }

    @Override
    public void insert(FacturaDTO facturaDTO) {

    }
}
