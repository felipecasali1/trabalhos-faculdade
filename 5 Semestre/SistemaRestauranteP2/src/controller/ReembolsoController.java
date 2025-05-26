package controller;

import dao.ReembolsoDAO;
import dao.ReembolsoDAOImpl;
import dto.ReembolsoDTO;
import models.Reembolso;

import java.util.List;

public class ReembolsoController extends InterfaceController {
    public void insert(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.insert(reembolsoDTO.builder());
    }

    public void update(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.update(reembolsoDTO.builder());
    }

    public void delete(ReembolsoDTO reembolsoDTO) {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        dao.delete(reembolsoDTO.builder());
    }

    public List<Reembolso> list() {
        ReembolsoDAO dao = new ReembolsoDAOImpl();
        return dao.list();
    }
}
