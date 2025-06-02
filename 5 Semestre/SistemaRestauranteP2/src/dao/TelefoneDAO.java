package dao;

import models.Telefone;
import java.util.List;

public interface TelefoneDAO {
    boolean insert(Telefone telefone);
    List<Telefone> list();
    List<Telefone> listByClienteId(Integer clienteId);
    List<Telefone> listByFuncionarioId(Integer funcionarioId);
    Telefone getById(Integer id);
    boolean update(Telefone telefone);
    boolean delete(Telefone telefone);
}
