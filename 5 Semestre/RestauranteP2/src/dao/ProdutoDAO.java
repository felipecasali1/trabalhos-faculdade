package dao;

import java.util.List;
import models.Produto;

public interface ProdutoDAO {
    void insert(Produto produto);
    List<Produto> list();
    Produto getById(Integer id);
    void update(Produto produto);
    void delete(Produto produto);
}
