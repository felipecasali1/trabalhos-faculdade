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
    public void insert(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.insert(ingredienteEscolhaDTO.buildEntity());
    }

    public void update(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.update(ingredienteEscolhaDTO.buildEntity());
    }

    public void delete(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.delete(ingredienteEscolhaDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        for (IngredienteEscolha ie : dao.list()) {
            listDTO.add(IngredienteEscolhaDTO.buildDTO(ie));
        }
        return listDTO;
    }
}
