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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        FuncionarioDTO funcionarioDTO = (FuncionarioDTO) interfaceDTO;
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return dao.insert(funcionarioDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        FuncionarioDTO funcionarioDTO = (FuncionarioDTO) interfaceDTO;
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return dao.update(funcionarioDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        FuncionarioDTO funcionarioDTO = (FuncionarioDTO) interfaceDTO;
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return dao.delete(funcionarioDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        for (Funcionario f : dao.list()) {
            listDTO.add(FuncionarioDTO.toDTO(f));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return FuncionarioDTO.toDTO(dao.getById(id));
    }
}
