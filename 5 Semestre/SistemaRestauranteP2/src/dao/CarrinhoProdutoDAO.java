package dao;

import java.util.List;
import models.CarrinhoProduto;

public interface CarrinhoProdutoDAO {
    boolean insert(CarrinhoProduto carrinhoProduto);
    List<CarrinhoProduto> list();
    CarrinhoProduto getById(Integer id);
    List<CarrinhoProduto> listByCarrinhoId(Integer carrinhoId);
    boolean update(CarrinhoProduto carrinhoProduto);
    boolean delete(CarrinhoProduto carrinhoProduto);
}
