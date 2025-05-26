package controller;


import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dto.ClienteDTO;
import models.Cliente;

import java.util.List;

public class ClienteController extends InterfaceController {
    public void insert(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.insert(clienteDTO.builder());
    }

    public void update(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.update(clienteDTO.builder());
    }

    public void delete(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.delete(clienteDTO.builder());
    }

    public List<Cliente> list() {
        //Corrigir para retornar List<ClienteDTO>
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.list();
    }
}
