package controller;

import interfaces.InterfaceController;
import dao.EntregaDAO;
import dao.EntregaDAOImpl;
import dto.EntregaDTO;
import interfaces.InterfaceDTO;
import models.Entrega;

import java.util.LinkedList;
import java.util.List;

public class EntregaController extends InterfaceController {
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        EntregaDTO entregaDTO = (EntregaDTO) interfaceDTO;
        EntregaDAO dao = new EntregaDAOImpl();
        return dao.insert(entregaDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        EntregaDTO entregaDTO = (EntregaDTO) interfaceDTO;
        EntregaDAO dao = new EntregaDAOImpl();
        return dao.update(entregaDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        EntregaDTO entregaDTO = (EntregaDTO) interfaceDTO;
        EntregaDAO dao = new EntregaDAOImpl();
        return dao.delete(entregaDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        EntregaDAO dao = new EntregaDAOImpl();
        for (Entrega e : dao.list()) {
            listDTO.add(EntregaDTO.toDTO(e));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        EntregaDAO dao = new EntregaDAOImpl();
        return EntregaDTO.toDTO(dao.getById(id));
    }
}
