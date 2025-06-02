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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        PagamentoDTO pagamentoDTO = (PagamentoDTO) interfaceDTO;
        PagamentoDAO dao = new PagamentoDAOImpl();
        return dao.insert(pagamentoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        PagamentoDTO pagamentoDTO = (PagamentoDTO) interfaceDTO;
        PagamentoDAO dao = new PagamentoDAOImpl();
        return dao.update(pagamentoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        PagamentoDTO pagamentoDTO = (PagamentoDTO) interfaceDTO;
        PagamentoDAO dao = new PagamentoDAOImpl();
        return dao.delete(pagamentoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        PagamentoDAO dao = new PagamentoDAOImpl();
        for (Pagamento p : dao.list()) {
            listDTO.add(PagamentoDTO.toDTO(p));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
