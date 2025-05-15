package dao;

import models.Login;

import java.util.List;

public interface LoginDAO {
    void insert(Login login);
    List<Login> list();
    Login getById(Integer id);
    void update(Login login);
    void delete(Login login);
}
