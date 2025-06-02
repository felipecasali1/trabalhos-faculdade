package dao;

import models.Telefone;
import java.util.List;

public interface TelefoneDAO {
    void insert(Telefone telefone);
    List<Telefone> list();
    List<Telefone> listByClienteId(Integer clienteId);
    List<Telefone> listByFuncionarioId(Integer funcionarioId);
    Telefone getById(Integer id);
    void update(Telefone telefone);
    void delete(Telefone telefone);
}
