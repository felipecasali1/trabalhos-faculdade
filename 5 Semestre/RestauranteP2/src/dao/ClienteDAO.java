package dao;

import models.Cliente;
import java.util.List;

public interface ClienteDAO {
    void insert(Cliente cliente);
    List<Cliente> list();
    Cliente getById(Integer id);
    void update(Cliente cliente);
    void delete(Cliente cliente);
}
