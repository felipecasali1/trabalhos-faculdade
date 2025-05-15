package dao;

import models.IngredienteRemover;

import java.util.List;

public interface IngredienteRemoverDAO {
    void insert(IngredienteRemover ingRem);
    List<IngredienteRemover> list();
    IngredienteRemover getById(Integer id);
    List<IngredienteRemover> listByEscolhaId(Integer escolhaId);
    void update(IngredienteRemover ingRem);
    void delete(IngredienteRemover ingRem);
}
