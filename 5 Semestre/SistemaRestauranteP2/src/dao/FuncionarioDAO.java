package dao;

import models.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    boolean insert(Funcionario funcionario);
    List<Funcionario> list();
    Funcionario getById(Integer id);
    boolean update(Funcionario funcionario);
    boolean delete(Funcionario funcionario);
}
