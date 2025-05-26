package controller;

import dao.IngredienteAdicionarDAO;
import dao.IngredienteAdicionarDAOImpl;
import dto.IngredienteAdicionarDTO;
import models.IngredienteAdicionar;

import java.util.List;

public class IngredienteAdicionarController extends InterfaceController {
    public void insert(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.insert(ingredienteAdicionarDTO.builder());
    }

    public void update(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.update(ingredienteAdicionarDTO.builder());
    }

    public void delete(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.delete(ingredienteAdicionarDTO.builder());
    }

    public List<IngredienteAdicionar> list() {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        return dao.list();
    }
}
