package main.java.DAO;

import main.java.DTO.FacturaDTO;
import main.java.MysqlManager;
import org.apache.commons.csv.CSVRecord;

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
    public void insert(CSVRecord row) {
        Integer idfactura = Integer.valueOf(row.get("idFactura"));
        Integer idcliente = Integer.valueOf(row.get("idCliente"));

        String createTableQuery = "INSERT INTO facturas (idfactura, idcliente) VALUES ("
                + idfactura + ", "
                + idcliente + ") ";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }
}
