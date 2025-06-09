package controller;

import interfaces.InterfaceController;
import dao.IngredienteAdicionarDAO;
import dao.IngredienteAdicionarDAOImpl;
import dto.IngredienteAdicionarDTO;
import interfaces.InterfaceDTO;
import models.IngredienteAdicionar;

import java.util.LinkedList;
import java.util.List;

public class IngredienteAdicionarController extends InterfaceController {
    public IngredienteAdicionarController() {
        this.interfaceDTO = new IngredienteAdicionarDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        IngredienteAdicionarDTO ingredienteAdicionarDTO = (IngredienteAdicionarDTO) interfaceDTO;
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        return dao.insert(ingredienteAdicionarDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        IngredienteAdicionarDTO ingredienteAdicionarDTO = (IngredienteAdicionarDTO) interfaceDTO;
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        return dao.update(ingredienteAdicionarDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        IngredienteAdicionarDTO ingredienteAdicionarDTO = (IngredienteAdicionarDTO) interfaceDTO;
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        return dao.delete(ingredienteAdicionarDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        for (IngredienteAdicionar ia : dao.list()) {
            listDTO.add(IngredienteAdicionarDTO.toDTO(ia));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
       IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
       return IngredienteAdicionarDTO.toDTO(dao.getById(id));
    }
}
