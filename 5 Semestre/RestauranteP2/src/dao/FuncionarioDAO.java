package dao;

import models.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    void insert(Funcionario funcionario);
    List<Funcionario> list();
    Funcionario getById(Integer id);
    void update(Funcionario funcionario);
    void delete(Funcionario funcionario);
}
