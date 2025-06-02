package dao;

import java.util.List;
import models.Bairro;

public interface BairroDAO {
    void insert(Bairro bairro);
    List<Bairro> list();
    Bairro getById(Integer id);
    void update(Bairro bairro);
    void delete(Bairro bairro);
}
