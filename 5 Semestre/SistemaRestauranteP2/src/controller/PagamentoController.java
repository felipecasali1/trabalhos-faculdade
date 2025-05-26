package controller;

import dao.PagamentoDAO;
import dao.PagamentoDAOImpl;
import dto.PagamentoDTO;
import models.Pagamento;

import java.util.List;

public class PagamentoController extends InterfaceController {
    public void insert(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.insert(pagamentoDTO.builder());
    }

    public void update(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.update(pagamentoDTO.builder());
    }

    public void delete(PagamentoDTO pagamentoDTO) {
        PagamentoDAO dao = new PagamentoDAOImpl();
        dao.delete(pagamentoDTO.builder());
    }

    public List<Pagamento> list() {
        PagamentoDAO dao = new PagamentoDAOImpl();
        return dao.list();
    }

}
