package controller;

import interfaces.InterfaceController;
import dao.ReembolsoDAO;
import dao.ReembolsoDAOImpl;
import dto.ReembolsoDTO;
import interfaces.InterfaceDTO;
import models.Reembolso;

import java.util.LinkedList;
import java.util.List;

public class ReembolsoController extends InterfaceController {
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        ReembolsoDTO reembolsoDTO = (ReembolsoDTO) interfaceDTO;
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        return dao.insert(reembolsoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        ReembolsoDTO reembolsoDTO = (ReembolsoDTO) interfaceDTO;
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        return dao.update(reembolsoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        ReembolsoDTO reembolsoDTO = (ReembolsoDTO) interfaceDTO;
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        return dao.delete(reembolsoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        for (Reembolso r : dao.list()) {
            listDTO.add(ReembolsoDTO.toDTO(r));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        return ReembolsoDTO.toDTO(dao.getById(id));
    }
}
