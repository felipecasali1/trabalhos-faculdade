package dao;

import java.util.List;
import models.IngredienteAdicionar;

public interface IngredienteAdicionarDAO {
    boolean insert(IngredienteAdicionar ingAdd);
    List<IngredienteAdicionar> list();
    IngredienteAdicionar getById(Integer id);
    List<IngredienteAdicionar> listByEscolhaId(Integer escolhaId);
    boolean update(IngredienteAdicionar ingAdd);
    boolean delete(IngredienteAdicionar ingAdd);
}
