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
    public void insert(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.insert(reembolsoDTO.buildEntity());
    }

    public void update(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.update(reembolsoDTO.buildEntity());
    }

    public void delete(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.delete(reembolsoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        for (Reembolso r : dao.list()) {
            listDTO.add(ReembolsoDTO.buildDTO(r));
        }
        return listDTO;
    }
}
