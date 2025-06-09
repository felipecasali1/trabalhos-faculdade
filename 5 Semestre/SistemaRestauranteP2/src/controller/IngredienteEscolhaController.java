package controller;

import interfaces.InterfaceController;
import dao.IngredienteEscolhaDAO;
import dao.IngredienteEscolhaDAOImpl;
import dto.IngredienteEscolhaDTO;
import interfaces.InterfaceDTO;
import models.IngredienteEscolha;

import java.util.LinkedList;
import java.util.List;

public class IngredienteEscolhaController extends InterfaceController {
    public IngredienteEscolhaController() {
        this.interfaceDTO = new IngredienteEscolhaDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        IngredienteEscolhaDTO ingredienteEscolhaDTO = (IngredienteEscolhaDTO) interfaceDTO;
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return dao.insert(ingredienteEscolhaDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        IngredienteEscolhaDTO ingredienteEscolhaDTO = (IngredienteEscolhaDTO) interfaceDTO;
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return dao.update(ingredienteEscolhaDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        IngredienteEscolhaDTO ingredienteEscolhaDTO = (IngredienteEscolhaDTO) interfaceDTO;
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return dao.delete(ingredienteEscolhaDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        for (IngredienteEscolha ie : dao.list()) {
            listDTO.add(IngredienteEscolhaDTO.toDTO(ie));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return IngredienteEscolhaDTO.toDTO(dao.getById(id));
    }
}
