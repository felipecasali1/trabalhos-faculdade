package dao;

import java.util.List;
import models.Carrinho;

public interface CarrinhoDAO {
    boolean insert(Carrinho carrinho);
    List<Carrinho> list();
    Carrinho getById(Integer id);
    boolean update(Carrinho carrinho);
    boolean delete(Carrinho carrinho);
}
