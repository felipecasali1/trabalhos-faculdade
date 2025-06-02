package dao;

import java.util.List;
import models.CarrinhoProduto;

public interface CarrinhoProdutoDAO {
    void insert(CarrinhoProduto carrinhoProduto);
    List<CarrinhoProduto> list();
    CarrinhoProduto getById(Integer id);
    List<CarrinhoProduto> listByCarrinhoId(Integer carrinhoId);
    void update(CarrinhoProduto carrinhoProduto);
    void delete(CarrinhoProduto carrinhoProduto);
}
