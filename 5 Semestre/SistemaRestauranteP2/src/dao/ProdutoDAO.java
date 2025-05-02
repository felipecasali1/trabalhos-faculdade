package dao;

import java.util.List;
import models.Produto;

public interface ProdutoDAO {
    public abstract void insert(Produto produto);
    public abstract List<Produto> list();
    public abstract Produto getById(Integer id);
    public abstract void update(Produto produto);
    public abstract void delete(Produto produto);
}
