package controller;

import interfaces.InterfaceController;
import dao.IngredienteRemoverDAO;
import dao.IngredienteRemoverDAOImpl;
import dto.IngredienteRemoverDTO;
import interfaces.InterfaceDTO;
import models.IngredienteRemover;

import java.util.LinkedList;
import java.util.List;

public class IngredienteRemoverController extends InterfaceController {
    public IngredienteRemoverController() {
        this.interfaceDTO = new IngredienteRemoverDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        IngredienteRemoverDTO ingredienteRemoverDTO = (IngredienteRemoverDTO) interfaceDTO;
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        return dao.insert(ingredienteRemoverDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        IngredienteRemoverDTO ingredienteRemoverDTO = (IngredienteRemoverDTO) interfaceDTO;
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        return dao.update(ingredienteRemoverDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        IngredienteRemoverDTO ingredienteRemoverDTO = (IngredienteRemoverDTO) interfaceDTO;
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        return dao.delete(ingredienteRemoverDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        for (IngredienteRemover ir : dao.list()) {
            listDTO.add(IngredienteRemoverDTO.toDTO(ir));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        return IngredienteRemoverDTO.toDTO(dao.getById(id));
    }
}
