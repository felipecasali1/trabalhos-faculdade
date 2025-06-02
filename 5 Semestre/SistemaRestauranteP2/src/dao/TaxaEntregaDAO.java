package dao;

import models.TaxaEntrega;

import java.util.List;

public interface TaxaEntregaDAO {
    boolean insert(TaxaEntrega taxaEntrega);
    List<TaxaEntrega> list();
    TaxaEntrega getByEntregaId(Integer entregaId);
    boolean update(TaxaEntrega taxaEntrega);
    boolean delete(TaxaEntrega taxaEntrega);
}
