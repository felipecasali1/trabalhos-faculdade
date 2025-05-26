package controller;

import dao.EntregaDAO;
import dao.EntregaDAOImpl;
import dto.EntregaDTO;
import models.Entrega;

import java.util.List;

public class EntregaController extends InterfaceController {
    public void insert(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.insert(entregaDTO.builder());
    }

    public void update(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.update(entregaDTO.builder());
    }

    public void delete(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.delete(entregaDTO.builder());
    }

    public List<Entrega> list() {
        EntregaDAO dao = new EntregaDAOImpl();
        return dao.list();
    }
}
