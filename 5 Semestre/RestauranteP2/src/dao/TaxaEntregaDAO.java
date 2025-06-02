package dao;

import models.TaxaEntrega;

import java.util.List;

public interface TaxaEntregaDAO {
    void insert(TaxaEntrega taxaEntrega);
    List<TaxaEntrega> list();
    TaxaEntrega getByEntregaId(Integer entregaId);
    void update(TaxaEntrega taxaEntrega);
    void delete(TaxaEntrega taxaEntrega);
}
