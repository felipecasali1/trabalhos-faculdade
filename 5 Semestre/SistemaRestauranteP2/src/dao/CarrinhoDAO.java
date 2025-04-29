package dao;

import java.util.List;
import models.Carrinho;

public interface CarrinhoDAO {
    public abstract void insert(Carrinho carrinho);
    public abstract List<Carrinho> list();
    public abstract Carrinho getById(Integer id);
    public abstract void update(Carrinho carrinho);
    public abstract void delete(Carrinho carrinho);
}
