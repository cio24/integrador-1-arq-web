package main.java.DAO;

import main.java.DTO.ClienteDTO;
import main.java.MysqlManager;

import java.util.List;

public class ClienteMysqlDAO implements ClienteDAO {
    @Override
    public List<ClienteDTO> getClientesFacturaronMas() {
        return null;
    }

    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE clientes("
                + "idcliente INT, "
                + "nombre VARCHAR(500),"
                + "email VARCHAR(150),"
                + "PRIMARY KEY(idcliente))";

        MysqlManager.createTable(createTableQuery);
    }

    @Override
    public void insert(ClienteDTO clienteDTO) {

    }
}
