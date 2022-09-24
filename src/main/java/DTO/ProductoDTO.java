package main.java.DTO;

public class ProductoDTO {
    private int idproducto;
    private String nombre;
    private float valor;

    public ProductoDTO(int idproducto, String nombre, float valor) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "idproducto=" + idproducto +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
