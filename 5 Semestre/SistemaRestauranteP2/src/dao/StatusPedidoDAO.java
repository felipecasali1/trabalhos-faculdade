package dao;

import models.StatusPedido;

import java.util.List;

public interface StatusPedidoDAO {
    boolean insert(StatusPedido statusPedido);
    List<StatusPedido> list();
    StatusPedido getById(Integer id);
    boolean update(StatusPedido statusPedido);
    boolean delete(StatusPedido statusPedido);
}
