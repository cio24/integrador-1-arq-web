package main.java.DAO;

import main.java.DTO.ClienteDTO;
import main.java.MysqlManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteMysqlDAO implements ClienteDAO {
    @Override
    public List<ClienteDTO> getClientesFacturaronMas() {

        String query = "select f.idcliente, sum(p.valor*fp.cantidad) as facturacion \n" +
                "  from producto p \n" +
                "  join facturaproducto fp on p.idproducto = fp.idproducto\n" +
                "  join factura f on fp.idfactura = f.idfactura\n" +
                "  group by f.idcliente\n" +
                "  order by facturacion desc;";

        ResultSet rs = MysqlManager.getInstance().getDataQuery(query);
        List<ClienteDTO> results = new ArrayList<>();
        try{
            while (rs.next()) {
                int idCliente = rs.getInt(1);
                String nombre = rs.getString(2);
                String email = rs.getString(3);
                results.add(new ClienteDTO(idCliente,nombre,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public void createTable() {
        String createTableQuery = "CREATE TABLE clientes("
                + "idcliente INT, "
                + "nombre VARCHAR(500),"
                + "email VARCHAR(150),"
                + "PRIMARY KEY(idcliente))";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }

    @Override
    public void insert(ClienteDTO clienteDTO) {

    }
}
