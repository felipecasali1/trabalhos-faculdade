package dao;

import java.util.List;
import models.CarrinhoProduto;

public interface CarrinhoProdutoDAO {
    public abstract void insert(CarrinhoProduto carrinhoProduto);
    public abstract List<CarrinhoProduto> list();
    public abstract CarrinhoProduto getById(Integer id);
    public abstract List<CarrinhoProduto> listByCarrinhoId(Integer carrinhoId);
    public abstract void update(CarrinhoProduto carrinhoProduto);
    public abstract void delete(CarrinhoProduto carrinhoProduto);
}
