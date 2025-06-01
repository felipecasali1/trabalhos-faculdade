package controller;


import interfaces.InterfaceController;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dto.ClienteDTO;
import interfaces.InterfaceDTO;
import models.Cliente;

import java.util.LinkedList;
import java.util.List;

public class ClienteController extends InterfaceController {
    public void insert(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.insert(clienteDTO.buildEntity());
    }

    public void update(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.update(clienteDTO.buildEntity());
    }

    public void delete(ClienteDTO clienteDTO) {
        ClienteDAO dao = new ClienteDAOImpl();
        dao.delete(clienteDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ClienteDAO dao = new ClienteDAOImpl();
        for (Cliente c : dao.list()) {
            listDTO.add(ClienteDTO.buildDTO(c));
        }
        return listDTO;
    }
}
