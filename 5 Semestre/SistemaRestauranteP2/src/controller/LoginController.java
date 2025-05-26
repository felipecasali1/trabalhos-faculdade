package controller;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.LoginDTO;
import models.Login;

import java.util.List;

public class LoginController extends InterfaceController {
    public void insert(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.insert(loginDTO.builder());
    }

    public void update(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.update(loginDTO.builder());
    }

    public void delete(LoginDTO loginDTO) {
        LoginDAO dao = new LoginDAOImpl();
        dao.delete(loginDTO.builder());
    }

    public List<Login> list() {
        LoginDAO dao = new LoginDAOImpl();
        return dao.list();
    }
}
