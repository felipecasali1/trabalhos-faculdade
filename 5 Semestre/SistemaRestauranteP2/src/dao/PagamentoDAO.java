package dao;

import models.Pagamento;

import java.util.List;

public interface PagamentoDAO {
    public abstract void insert(Pagamento pagamento);
    public abstract List<Pagamento> list();
    public abstract Pagamento getByPedidoId(Integer pedidoId);
    public abstract void update(Pagamento pagamento);
    public abstract void delete(Pagamento pagamento);
}
