package controller;

import interfaces.InterfaceController;
import dao.PagamentoDAO;
import dao.PagamentoDAOImpl;
import dto.PagamentoDTO;
import interfaces.InterfaceDTO;
import models.Pagamento;

import java.util.LinkedList;
import java.util.List;

public class PagamentoController extends InterfaceController {
    public void insert(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.insert(pagamentoDTO.buildEntity());
    }

    public void update(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.update(pagamentoDTO.buildEntity());
    }

    public void delete(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.delete(pagamentoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        PagamentoDAO dao = new PagamentoDAOImpl();
        for (Pagamento p : dao.list()) {
            listDTO.add(PagamentoDTO.buildDTO(p));
        }
        return listDTO;
    }

}
