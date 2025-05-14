package dao;

import models.TaxaEntrega;

import java.util.List;

public interface TaxaEntregaDAO {
    public abstract void insert(TaxaEntrega taxaEntrega);
    public abstract List<TaxaEntrega> list();
    public abstract TaxaEntrega getByEntregaId(Integer entregaId);
    public abstract void update(TaxaEntrega taxaEntrega);
    public abstract void delete(TaxaEntrega taxaEntrega);
}
