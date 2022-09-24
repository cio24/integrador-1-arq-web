package main.java.FACTORY;

import main.java.DAO.ClienteDAO;
import main.java.DAO.DAO;
import main.java.DAO.ProductoDAO;

public interface DAOFactory {
    ClienteDAO getClienteDAO();
    ProductoDAO getProductoDAO();
    DAO getFacturaDAO();
    DAO getFacturaProductoDAO();
}
