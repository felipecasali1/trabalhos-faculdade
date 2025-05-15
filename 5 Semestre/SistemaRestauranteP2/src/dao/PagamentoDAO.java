package dao;

import models.Pagamento;

import java.util.List;

public interface PagamentoDAO {
    void insert(Pagamento pagamento);
    List<Pagamento> list();
    Pagamento getByPedidoId(Integer pedidoId);
    void update(Pagamento pagamento);
    void delete(Pagamento pagamento);
}
