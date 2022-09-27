package main.java;

import main.java.DAO.*;
import main.java.DTO.ClienteDTO;
import main.java.DTO.ProductoDTO;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        //1) Cree un programa utilizando JDBC que cree el esquema de la base de datos
        MysqlDAOFactory factory = new MysqlDAOFactory();
        ClienteDAO clienteDAO = factory.getClienteDAO();
        ProductoDAO productoDAO = factory.getProductoDAO();
        DAO facturaDAO = factory.getFacturaDAO();
        DAO facturaProductoDAO = factory.getFacturaProductoDAO();

        //clienteDAO.createTable();
       // productoDAO.createTable();
        facturaDAO.createTable();
        facturaProductoDAO.createTable();

        //2) Considere los CSV dados y escriba un programa JDBC que cargue los datos a la base de
        //datos. Considere utilizar la biblioteca Apache Commons CSV, disponible en Maven central,
        //para leer los archivos.
        MysqlManager mysqlManager = MysqlManager.getInstance();
        mysqlManager.insertDataToTable("resources/clientes.csv", new ClienteMysqlDAO());
        mysqlManager.insertDataToTable("resources/productos.csv", new ProductoMysqlDAO());
        mysqlManager.insertDataToTable("resources/facturas.csv", new FacturaMysqlDAO());
        mysqlManager.insertDataToTable("resources/facturas-productos.csv", new FacturaProductoMysqlDAO());


        //3) Escriba un programa JDBC que retorne el producto que mÃ¡s recaudÃ³. Se define
        //â€œrecaudaciÃ³nâ€� como cantidad de productos vendidos multiplicado por su valor.
        ProductoDTO producto = productoDAO.getProductoQueMasRecaudo();
        System.out.println("el producto que mÃ¡s recaudo es: " + producto.toString());


        //4) Escriba un programa JDBC que imprima una lista de clientes, ordenada por a cuÃ¡l se le
        //facturÃ³ mÃ¡s.
        List<ClienteDTO> clientes = clienteDAO.getClientesFacturaronMas();
        System.out.println("clientes ordenados por lo que mÃ¡s facturaron: ");
        for(ClienteDTO c: clientes)
            System.out.println(c.toString());
    }
}
