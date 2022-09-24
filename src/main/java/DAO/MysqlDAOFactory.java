package main.java.DAO;

import main.java.FACTORY.DAOFactory;

public class MysqlDAOFactory implements DAOFactory {
    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteMysqlDAO();
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new ProductoMysqlDAO();
    }

    @Override
    public DAO getFacturaDAO() {
        return new FacturaMysqlDAO();
    }

    @Override
    public DAO getFacturaProductoDAO() {
        return new FacturaProductoMysqlDAO();
    }
}
