package dao;

import java.util.List;
import models.IngredienteEscolha;

public interface IngredienteEscolhaDAO {
    boolean insert(IngredienteEscolha ingEscolha);
    List<IngredienteEscolha> list();
    IngredienteEscolha getById(Integer id);
    boolean update(IngredienteEscolha ingEscolha);
    boolean delete(IngredienteEscolha ingEscolha);
}
