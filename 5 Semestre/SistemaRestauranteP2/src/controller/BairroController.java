package controller;

import interfaces.InterfaceController;
import dao.BairroDAO;
import dao.BairroDAOImpl;
import dto.BairroDTO;
import interfaces.InterfaceDTO;
import models.Bairro;

import java.util.LinkedList;
import java.util.List;

public class BairroController extends InterfaceController {
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        BairroDTO bairroDTO = (BairroDTO) interfaceDTO;
        BairroDAO dao = new BairroDAOImpl();
        return dao.insert(bairroDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        BairroDTO bairroDTO = (BairroDTO) interfaceDTO;
        BairroDAO dao = new BairroDAOImpl();
        return dao.update(bairroDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        BairroDTO bairroDTO = (BairroDTO) interfaceDTO;
        BairroDAO dao = new BairroDAOImpl();
        return dao.delete(bairroDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        BairroDAO dao = new BairroDAOImpl();
        for (Bairro b : dao.list()) {
            listDTO.add(BairroDTO.toDTO(b));
        }
        return listDTO;
    }
    
    @Override
    public InterfaceDTO getById(Integer id) {
        BairroDAO dao = new BairroDAOImpl();
        return BairroDTO.toDTO(dao.getById(id));
    }
}
