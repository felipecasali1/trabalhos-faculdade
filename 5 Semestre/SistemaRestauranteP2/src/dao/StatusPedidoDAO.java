package dao;

import models.StatusPedido;

import java.util.List;

public interface StatusPedidoDAO {
    void insert(StatusPedido statusPedido);
    List<StatusPedido> list();
    StatusPedido getById(Integer id);
    void update(StatusPedido statusPedido);
    void delete(StatusPedido statusPedido);
}
