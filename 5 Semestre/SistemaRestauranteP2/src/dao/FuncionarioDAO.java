package dao;

import models.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    public abstract void insert(Funcionario funcionario);
    public abstract List<Funcionario> list();
    public abstract Funcionario getById(Integer id);
    public abstract void update(Funcionario funcionario);
    public abstract void delete(Funcionario funcionario);
}
