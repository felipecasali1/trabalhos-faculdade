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
    public void insert(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.insert(ingredienteRemoverDTO.buildEntity());
    }

    public void update(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.update(ingredienteRemoverDTO.buildEntity());
    }

    public void delete(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.delete(ingredienteRemoverDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        for (IngredienteRemover ir : dao.list()) {
            listDTO.add(IngredienteRemoverDTO.buildDTO(ir));
        }
        return listDTO;
    }
}
