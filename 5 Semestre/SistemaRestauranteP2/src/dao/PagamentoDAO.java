package dao;

import models.Pagamento;

import java.util.List;

public interface PagamentoDAO {
    boolean insert(Pagamento pagamento);
    List<Pagamento> list();
    Pagamento getByPedidoId(Integer pedidoId);
    boolean update(Pagamento pagamento);
    boolean delete(Pagamento pagamento);
}
