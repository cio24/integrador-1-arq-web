package main.java.DTO;

public class ClienteDTO {
    private int idcliente;
    private String nombre;
    private String email;

    public ClienteDTO(int idcliente, String nombre, String email) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
