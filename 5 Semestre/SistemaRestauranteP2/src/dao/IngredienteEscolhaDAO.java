package dao;

import java.util.List;
import models.IngredienteEscolha;

public interface IngredienteEscolhaDAO {
    public abstract void insert(IngredienteEscolha ingEscolha);
    public abstract List<IngredienteEscolha> list();
    public abstract IngredienteEscolha getById(Integer id);
    public abstract void update(IngredienteEscolha ingEscolha);
    public abstract void delete(IngredienteEscolha ingEscolha);
}
