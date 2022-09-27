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

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();


		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		String uri = "jdbc:mysql://localhost:3306/integrador1";

		ProductoDTO p = null;

		try {
			Connection conn = DriverManager.getConnection(uri, "root", "example");
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement("select p.idproducto, p.nombre, sum(p.valor*fp.cantidad) as recaudacion "
					+ "	 from producto p join facturaproducto fp on p.idproducto = fp.idproducto"
					+ "  group by p.idproducto, p.nombre"
					+ "  order by recaudacion desc"
					+ "  limit 1;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
			conn.commit();
			conn.close();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}

