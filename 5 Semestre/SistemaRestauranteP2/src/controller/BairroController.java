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
    public void insert(BairroDTO bairroDTO) {
        BairroDAO dao = new BairroDAOImpl();
        dao.insert(bairroDTO.buildEntity());
    }

    public void update(BairroDTO bairroDTO) {
        BairroDAO dao = new BairroDAOImpl();
        dao.update(bairroDTO.buildEntity());
    }

    public void delete(BairroDTO bairroDTO) {
        BairroDAO dao = new BairroDAOImpl();
        dao.delete(bairroDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        BairroDAO dao = new BairroDAOImpl();
        for (Bairro b : dao.list()) {
            listDTO.add(BairroDTO.buildDTO(b));
        }
        return listDTO;
    }
}
