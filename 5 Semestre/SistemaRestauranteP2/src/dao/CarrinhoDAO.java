package dao;

import java.util.List;
import models.Carrinho;

public interface CarrinhoDAO {
    void insert(Carrinho carrinho);
    List<Carrinho> list();
    Carrinho getById(Integer id);
    void update(Carrinho carrinho);
    void delete(Carrinho carrinho);
}
