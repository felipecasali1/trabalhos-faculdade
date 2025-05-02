package dao;

import models.IngredienteRemover;

import java.util.List;

public interface IngredienteRemoverDAO {
    public abstract void insert(IngredienteRemover ingRem);
    public abstract List<IngredienteRemover> list();
    public abstract IngredienteRemover getById(Integer id);
    public abstract List<IngredienteRemover> listByEscolhaId(Integer escolhaId);
    public abstract void update(IngredienteRemover ingRem);
    public abstract void delete(IngredienteRemover ingRem);
}
