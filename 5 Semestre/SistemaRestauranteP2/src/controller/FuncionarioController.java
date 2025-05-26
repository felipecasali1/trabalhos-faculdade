package controller;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import dto.FuncionarioDTO;
import models.Funcionario;

import java.util.List;

public class FuncionarioController extends InterfaceController {
    public void insert(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.insert(funcionarioDTO.builder());
    }

    public void update(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.update(funcionarioDTO.builder());
    }

    public void delete(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.delete(funcionarioDTO.builder());
    }

    public List<Funcionario> list() {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return dao.list();
    }
}
