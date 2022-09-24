package main.java.DAO;

import main.java.DTO.ClienteDTO;

import java.util.List;

public interface ClienteDAO extends DAO<ClienteDTO> {
    List<ClienteDTO> getClientesFacturaronMas();
}
