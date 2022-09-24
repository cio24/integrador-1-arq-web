package main.java.DAO;

import main.java.DTO.ProductoDTO;

public interface ProductoDAO extends DAO<ProductoDTO> {
    ProductoDTO getProductoQueMasRecaudo();
}
