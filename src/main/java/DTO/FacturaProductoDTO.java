package main.java.DTO;

public class FacturaProductoDTO {
    private int idfactura;
    private int idproducto;
    private int cantidad;

    public FacturaProductoDTO(int idfactura, int idproducto, int cantidad) {
        this.idfactura = idfactura;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
    }
}
