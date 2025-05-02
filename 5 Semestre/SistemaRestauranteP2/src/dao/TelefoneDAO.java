package dao;

import models.Telefone;
import java.util.List;

public interface TelefoneDAO {
    public abstract void insert(Telefone telefone);
    public abstract List<Telefone> list();
    public abstract List<Telefone> listByClienteId(Integer clienteId);
    public abstract List<Telefone> listByFuncionarioId(Integer funcionarioId);
    public abstract Telefone getById(Integer id);
    public abstract void update(Telefone telefone);
    public abstract void delete(Telefone telefone);
}
