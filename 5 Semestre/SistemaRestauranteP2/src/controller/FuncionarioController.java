package controller;

import interfaces.InterfaceController;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import dto.FuncionarioDTO;
import interfaces.InterfaceDTO;
import models.Funcionario;

import java.util.LinkedList;
import java.util.List;

public class FuncionarioController extends InterfaceController {
    public void insert(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.insert(funcionarioDTO.buildEntity());
    }

    public void update(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.update(funcionarioDTO.buildEntity());
    }

    public void delete(FuncionarioDTO funcionarioDTO) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.delete(funcionarioDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        for (Funcionario f : dao.list()) {
            listDTO.add(FuncionarioDTO.buildDTO(f));
        }
        return listDTO;
    }
}
