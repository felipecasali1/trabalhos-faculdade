package controller;

import dao.CupomDAO;
import dao.CupomDAOImpl;
import dto.CupomDTO;
import models.Cupom;

import java.util.List;

public class CupomController extends InterfaceController {
    public void insert(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.insert(cupomDTO.builder());
    }

    public void update(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.update(cupomDTO.builder());
    }

    public void delete(CupomDTO cupomDTO) {
        CupomDAO dao = new CupomDAOImpl();
        dao.delete(cupomDTO.builder());
    }

    public List<Cupom> list() {
        //Corrigir para retornar List<CupomDTO>
        CupomDAO dao = new CupomDAOImpl();
        return dao.list();
    }
}
