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
    public void insert(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.insert(loginDTO.buildEntity());
    }

    public void update(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.update(loginDTO.buildEntity());
    }

    public void delete(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.delete(loginDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        LoginDAO dao = new LoginDAOImpl();
        for (Login l : dao.list()) {
            listDTO.add(LoginDTO.buildDTO(l));
        }
        return listDTO;
    }
}
