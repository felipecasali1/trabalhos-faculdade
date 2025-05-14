package dao;

import models.Pedido;

import java.util.List;

public interface PedidoDAO {
    public abstract void insert(Pedido pedido);
    public abstract List<Pedido> list();
    public abstract Pedido getById(Integer id);
    public abstract void update(Pedido pedido);
    public abstract void delete(Pedido pedido);
}
