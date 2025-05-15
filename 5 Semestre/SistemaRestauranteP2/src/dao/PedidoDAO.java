package dao;

import models.Pedido;

import java.util.List;

public interface PedidoDAO {
    void insert(Pedido pedido);
    List<Pedido> list();
    Pedido getById(Integer id);
    void update(Pedido pedido);
    void delete(Pedido pedido);
}
