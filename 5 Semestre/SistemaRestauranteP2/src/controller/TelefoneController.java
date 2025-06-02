package controller;

import interfaces.InterfaceController;
import dao.TelefoneDAO;
import dao.TelefoneDAOImpl;
import dto.TelefoneDTO;
import interfaces.InterfaceDTO;
import models.Telefone;

import java.util.LinkedList;
import java.util.List;

public class TelefoneController extends InterfaceController {
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        TelefoneDTO telefoneDTO = (TelefoneDTO) interfaceDTO;
        TelefoneDAO dao = new TelefoneDAOImpl();
        return dao.insert(telefoneDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        TelefoneDTO telefoneDTO = (TelefoneDTO) interfaceDTO;
        TelefoneDAO dao = new TelefoneDAOImpl();
        return dao.update(telefoneDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        TelefoneDTO telefoneDTO = (TelefoneDTO) interfaceDTO;
        TelefoneDAO dao = new TelefoneDAOImpl();
        return dao.delete(telefoneDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        TelefoneDAO dao = new TelefoneDAOImpl();
        for (Telefone t : dao.list()) {
            listDTO.add(TelefoneDTO.toDTO(t));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        return TelefoneDTO.toDTO(dao.getById(id));
    }
}
