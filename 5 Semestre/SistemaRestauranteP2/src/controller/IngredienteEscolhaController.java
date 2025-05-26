package controller;

import dao.IngredienteEscolhaDAO;
import dao.IngredienteEscolhaDAOImpl;
import dto.IngredienteEscolhaDTO;
import models.IngredienteEscolha;

import java.util.List;

public class IngredienteEscolhaController extends InterfaceController {
    public void insert(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.insert(ingredienteEscolhaDTO.builder());
    }

    public void update(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.update(ingredienteEscolhaDTO.builder());
    }

    public void delete(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        dao.delete(ingredienteEscolhaDTO.builder());
    }

    public List<IngredienteEscolha> list() {
        IngredienteEscolhaDAO dao = new IngredienteEscolhaDAOImpl();
        return dao.list();
    }
}
