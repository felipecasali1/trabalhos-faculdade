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
    public TaxaEntregaController() {
        this.interfaceDTO = new TaxaEntregaDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        TaxaEntregaDTO taxaEntregaDTO = (TaxaEntregaDTO) interfaceDTO;
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        return dao.insert(taxaEntregaDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        TaxaEntregaDTO taxaEntregaDTO = (TaxaEntregaDTO) interfaceDTO;
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        return dao.update(taxaEntregaDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        TaxaEntregaDTO taxaEntregaDTO = (TaxaEntregaDTO) interfaceDTO;
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        return dao.delete(taxaEntregaDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        TaxaEntregaDAO dao = new TaxaEntregaDAOImpl();
        for (TaxaEntrega te : dao.list()) {
            listDTO.add(TaxaEntregaDTO.toDTO(te));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
