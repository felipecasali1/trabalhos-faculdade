package dao;

import models.Login;

import java.util.List;

public interface LoginDAO {
    public abstract void insert(Login login);
    public abstract List<Login> list();
    public abstract Login getById(Integer id);
    public abstract void update(Login login);
    public abstract void delete(Login login);
}
