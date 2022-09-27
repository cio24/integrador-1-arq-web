package main.java.DAO;

import java.sql.SQLException;

import main.java.DTO.ProductoDTO;

public interface ProductoDAO extends DAO<ProductoDTO> {
	ProductoDTO getProductoQueMasRecaudo();
}
