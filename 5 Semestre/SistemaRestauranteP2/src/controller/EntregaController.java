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
    public void insert(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.insert(entregaDTO.buildEntity());
    }

    public void update(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.update(entregaDTO.buildEntity());
    }

    public void delete(EntregaDTO entregaDTO) {
        EntregaDAO dao = new EntregaDAOImpl();
        dao.delete(entregaDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        EntregaDAO dao = new EntregaDAOImpl();
        for (Entrega e : dao.list()) {
            listDTO.add(EntregaDTO.buildDTO(e));
        }
        return listDTO;
    }
}
