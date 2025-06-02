package dao;

import java.util.List;
import models.IngredienteEscolha;

public interface IngredienteEscolhaDAO {
    void insert(IngredienteEscolha ingEscolha);
    List<IngredienteEscolha> list();
    IngredienteEscolha getById(Integer id);
    void update(IngredienteEscolha ingEscolha);
    void delete(IngredienteEscolha ingEscolha);
}
