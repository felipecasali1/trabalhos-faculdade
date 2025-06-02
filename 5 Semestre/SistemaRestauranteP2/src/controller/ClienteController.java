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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        ClienteDTO clienteDTO = (ClienteDTO) interfaceDTO;
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.insert(clienteDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        ClienteDTO clienteDTO = (ClienteDTO) interfaceDTO;
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.update(clienteDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        ClienteDTO clienteDTO = (ClienteDTO) interfaceDTO;
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.delete(clienteDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ClienteDAO dao = new ClienteDAOImpl();
        for (Cliente c : dao.list()) {
            listDTO.add(ClienteDTO.toDTO(c));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        ClienteDAO dao = new ClienteDAOImpl();
        return ClienteDTO.toDTO(dao.getById(id));
    }
}
