package dao;

import models.Cliente;
import java.util.List;

public interface ClienteDAO {
    boolean insert(Cliente cliente);
    List<Cliente> list();
    Cliente getById(Integer id);
    boolean update(Cliente cliente);
    boolean delete(Cliente cliente);
}
