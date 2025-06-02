package controller;

import interfaces.InterfaceController;
import dao.CupomDAO;
import dao.CupomDAOImpl;
import dto.CupomDTO;
import interfaces.InterfaceDTO;
import models.Cupom;

import java.util.LinkedList;
import java.util.List;

public class CupomController extends InterfaceController {
    public void insert(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.insert(cupomDTO.buildEntity());
    }

    public void update(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.update(cupomDTO.buildEntity());
    }

    public void delete(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.delete(cupomDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CupomDAO dao = new CupomDAOImpl();
        for (Cupom c : dao.list()) {
            listDTO.add(CupomDTO.buildDTO(c));
        }
        return listDTO;
    }
}
