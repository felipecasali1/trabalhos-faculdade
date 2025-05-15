package dao;


import models.Entrega;

import java.util.List;

public interface EntregaDAO {
    void insert(Entrega entrega);
    List<Entrega> list();
    Entrega getById(Integer id);
    void update(Entrega entrega);
    void delete(Entrega entrega);
}
