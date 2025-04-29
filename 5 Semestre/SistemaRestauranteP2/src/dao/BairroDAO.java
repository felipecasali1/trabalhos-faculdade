package dao;

import java.util.List;
import models.Bairro;

public interface BairroDAO {
    public abstract void insert(Bairro bairro);
    public abstract List<Bairro> list();
    public abstract Bairro getById(Integer id);
    public abstract void update(Bairro bairro);
    public abstract void delete(Bairro bairro);
}
