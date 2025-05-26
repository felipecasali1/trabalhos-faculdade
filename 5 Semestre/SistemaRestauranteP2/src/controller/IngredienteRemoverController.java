package controller;

import dao.IngredienteRemoverDAO;
import dao.IngredienteRemoverDAOImpl;
import dto.IngredienteRemoverDTO;
import models.IngredienteRemover;

import java.util.List;

public class IngredienteRemoverController extends InterfaceController {
    public void insert(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.insert(ingredienteRemoverDTO.builder());
    }

    public void update(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.update(ingredienteRemoverDTO.builder());
    }

    public void delete(IngredienteRemoverDTO ingredienteRemoverDTO) {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        dao.delete(ingredienteRemoverDTO.builder());
    }

    public List<IngredienteRemover> list() {
        IngredienteRemoverDAO dao = new IngredienteRemoverDAOImpl();
        return dao.list();
    }
}
