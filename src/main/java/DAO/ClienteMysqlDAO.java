package main.java.DAO;

import main.java.DTO.ClienteDTO;
import main.java.MysqlManager;
import org.apache.commons.csv.CSVRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteMysqlDAO implements ClienteDAO {
    @Override
    public List<ClienteDTO> getClientesFacturaronMas() {
    	
    	String query = "SELECT f.idcliente, c.nombre, c.email, SUM(p.valor*fp.cantidad) AS facturacion\r\n"
    			+ "FROM productos p\r\n"
    			+ "JOIN facturasproductos fp ON p.idproducto = fp.idproducto\r\n"
    			+ "JOIN facturas f ON fp.idfactura = f.idfactura\r\n"
    			+ "JOIN clientes c ON f.idcliente = c.idcliente\r\n"
    			+ "GROUP BY f.idcliente\r\n"
    			+ "ORDER BY facturacion DESC";

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
        
        MysqlManager.getInstance().closeConnection();
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
    public void insert(CSVRecord row) {

        String name = row.get("nombre");
        String email = row.get("email");
        Integer id = Integer.valueOf(row.get("idCliente"));

        String createTableQuery = "INSERT INTO clientes (idcliente, nombre, email) VALUES ("
                + id + ", '"
                + name + "', '"
                + email + "')";

        MysqlManager.getInstance().voidQuery(createTableQuery);
    }
}
