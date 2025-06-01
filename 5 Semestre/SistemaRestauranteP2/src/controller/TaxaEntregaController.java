package controller;

import interfaces.InterfaceController;
import dao.TaxaEntregaDAO;
import dao.TaxaEntregaDAOImpl;
import dto.TaxaEntregaDTO;
import interfaces.InterfaceDTO;
import models.TaxaEntrega;

import java.util.LinkedList;
import java.util.List;

public class TaxaEntregaController extends InterfaceController {
    public void insert(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.insert(taxaEntregaDTO.buildEntity());
    }

    public void update(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.update(taxaEntregaDTO.buildEntity());
    }

    public void delete(TaxaEntregaDTO taxaEntregaDTO) {
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        dao.delete(taxaEntregaDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        for (TaxaEntrega te : dao.list()) {
            listDTO.add(TaxaEntregaDTO.buildDTO(te));
        }
        return listDTO;
    }
}
