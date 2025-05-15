package dao;

import java.util.List;
import models.IngredienteAdicionar;

public interface IngredienteAdicionarDAO {
    void insert(IngredienteAdicionar ingAdd);
    List<IngredienteAdicionar> list();
    IngredienteAdicionar getById(Integer id);
    List<IngredienteAdicionar> listByEscolhaId(Integer escolhaId);
    void update(IngredienteAdicionar ingAdd);
    void delete(IngredienteAdicionar ingAdd);
}
