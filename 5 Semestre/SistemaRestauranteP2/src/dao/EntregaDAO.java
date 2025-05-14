package dao;


import models.Entrega;

import java.util.List;

public interface EntregaDAO {
    public abstract void insert(Entrega entrega);
    public abstract List<Entrega> list();
    public abstract Entrega getById(Integer id);
    public abstract void update(Entrega entrega);
    public abstract void delete(Entrega entrega);
}
