package controller;

import interfaces.InterfaceController;
import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.LoginDTO;
import interfaces.InterfaceDTO;
import models.Login;

import java.util.LinkedList;
import java.util.List;

public class LoginController extends InterfaceController {
    public LoginController() {
        this.interfaceDTO = new LoginDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        LoginDTO loginDTO = (LoginDTO) interfaceDTO;
        LoginDAO dao = new LoginDAOImpl();
        return dao.insert(loginDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        LoginDTO loginDTO = (LoginDTO) interfaceDTO;
        LoginDAO dao = new LoginDAOImpl();
        return dao.update(loginDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        LoginDTO loginDTO = (LoginDTO) interfaceDTO;
        LoginDAO dao = new LoginDAOImpl();
        return dao.delete(loginDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        LoginDAO dao = new LoginDAOImpl();
        for (Login l : dao.list()) {
            listDTO.add(LoginDTO.toDTO(l));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        LoginDAO dao = new LoginDAOImpl();
        return LoginDTO.toDTO(dao.getById(id));
    }
}
