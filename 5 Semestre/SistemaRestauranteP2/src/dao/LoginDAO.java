package dao;

import models.Login;

import java.util.List;

public interface LoginDAO {
    boolean insert(Login login);
    List<Login> list();
    Login getById(Integer id);
    boolean update(Login login);
    boolean delete(Login login);
}
