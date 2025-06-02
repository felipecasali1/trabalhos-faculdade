package dao;

import java.util.List;
import models.Produto;

public interface ProdutoDAO {
    boolean insert(Produto produto);
    List<Produto> list();
    Produto getById(Integer id);
    boolean update(Produto produto);
    boolean delete(Produto produto);
}
