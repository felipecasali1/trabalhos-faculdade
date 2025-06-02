package dao;


import models.Entrega;

import java.util.List;

public interface EntregaDAO {
    boolean insert(Entrega entrega);
    List<Entrega> list();
    Entrega getById(Integer id);
    boolean update(Entrega entrega);
    boolean delete(Entrega entrega);
}
