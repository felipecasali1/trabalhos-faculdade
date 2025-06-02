package dao;

import models.Pedido;

import java.util.List;

public interface PedidoDAO {
    boolean insert(Pedido pedido);
    List<Pedido> list();
    Pedido getById(Integer id);
    boolean update(Pedido pedido);
    boolean delete(Pedido pedido);
}
