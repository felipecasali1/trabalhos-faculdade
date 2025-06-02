package dao;

import models.IngredienteRemover;

import java.util.List;

public interface IngredienteRemoverDAO {
    boolean insert(IngredienteRemover ingRem);
    List<IngredienteRemover> list();
    IngredienteRemover getById(Integer id);
    List<IngredienteRemover> listByEscolhaId(Integer escolhaId);
    boolean update(IngredienteRemover ingRem);
    boolean delete(IngredienteRemover ingRem);
}
