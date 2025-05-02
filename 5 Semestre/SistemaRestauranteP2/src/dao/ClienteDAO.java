package dao;

import models.Cliente;
import java.util.List;

public interface ClienteDAO {
    public abstract void insert(Cliente cliente);
    public abstract List<Cliente> list();
    public abstract Cliente getById(Integer id);
    public abstract void update(Cliente cliente);
    public abstract void delete(Cliente cliente);
}
