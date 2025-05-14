package dao;

import models.StatusPedido;

import java.util.List;

public interface StatusPedidoDAO {
    public abstract void insert(StatusPedido statusPedido);
    public abstract List<StatusPedido> list();
    public abstract StatusPedido getById(Integer id);
    public abstract void update(StatusPedido statusPedido);
    public abstract void delete(StatusPedido statusPedido);
}
