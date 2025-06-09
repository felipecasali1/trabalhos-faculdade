package controller;

import interfaces.InterfaceController;
import dao.CupomDAO;
import dao.CupomDAOImpl;
import dto.CupomDTO;
import interfaces.InterfaceDTO;
import models.Cupom;

import java.util.LinkedList;
import java.util.List;

public class CupomController extends InterfaceController {
    public CupomController() {
        this.interfaceDTO = new CupomDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        CupomDTO cupomDTO = (CupomDTO) interfaceDTO;
        CupomDAO dao = new CupomDAOImpl();
        return dao.insert(cupomDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        CupomDTO cupomDTO = (CupomDTO) interfaceDTO;
        CupomDAO dao = new CupomDAOImpl();
        return dao.update(cupomDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        CupomDTO cupomDTO = (CupomDTO) interfaceDTO;
        CupomDAO dao = new CupomDAOImpl();
        return dao.delete(cupomDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CupomDAO dao = new CupomDAOImpl();
        for (Cupom c : dao.list()) {
            listDTO.add(CupomDTO.toDTO(c));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        CupomDAO dao = new CupomDAOImpl();
        return CupomDTO.toDTO(dao.getById(id));
    }
}
