package main.java.DAO;

import main.java.DTO.ProductoDTO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		ProductoDTO producto = null;
		
		String query = "SELECT p.idproducto, p.nombre, SUM(p.valor*fp.cantidad) AS recaudacion\r\n"
				+ "FROM productos p JOIN facturasproductos fp ON p.idproducto = fp.idproducto\r\n"
				+ "GROUP BY p.idproducto, p.nombre\r\n"
				+ "ORDER BY recaudacion desc\r\n"
				+ "LIMIT 1;";
		
		ResultSet res = MysqlManager.getInstance().getDataQuery(query);
		
		try{
			while(res.next()) {
				producto = new ProductoDTO(res.getInt(1), res.getString(2), res.getFloat(3));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		MysqlManager.getInstance().closeConnection();
		return producto;
	}
}

