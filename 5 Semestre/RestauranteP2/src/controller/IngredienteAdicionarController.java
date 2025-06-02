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
    public void insert(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.insert(ingredienteAdicionarDTO.buildEntity());
    }

    public void update(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.update(ingredienteAdicionarDTO.buildEntity());
    }

    public void delete(IngredienteAdicionarDTO ingredienteAdicionarDTO) {
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        dao.delete(ingredienteAdicionarDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        IngredienteAdicionarDAO dao = new IngredienteAdicionarDAOImpl();
        for (IngredienteAdicionar ia : dao.list()) {
            listDTO.add(IngredienteAdicionarDTO.buildDTO(ia));
        }
        return listDTO;
    }
}
