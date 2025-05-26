package controller;

import dao.TaxaEntregaDAO;
import dao.TaxaEntregaDAOImpl;
import dto.TaxaEntregaDTO;
import models.TaxaEntrega;

import java.util.List;

public class TaxaEntregaController extends InterfaceController {
    public void insert(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.insert(taxaEntregaDTO.builder());
    }

    public void update(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.update(taxaEntregaDTO.builder());
    }

    public void delete(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.delete(taxaEntregaDTO.builder());
    }

    public List<TaxaEntrega> list() {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        return dao.list();
    }
}
