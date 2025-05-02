package dao;

import java.util.List;
import models.IngredienteAdicionar;

public interface IngredienteAdicionarDAO {
    public abstract void insert(IngredienteAdicionar ingAdd);
    public abstract List<IngredienteAdicionar> list();
    public abstract IngredienteAdicionar getById(Integer id);
    public abstract List<IngredienteAdicionar> listByEscolhaId(Integer escolhaId);
    public abstract void update(IngredienteAdicionar ingAdd);
    public abstract void delete(IngredienteAdicionar ingAdd);
}
