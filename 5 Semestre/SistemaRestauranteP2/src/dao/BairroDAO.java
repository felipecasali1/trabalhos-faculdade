package dao;

import java.util.List;
import models.Bairro;

public interface BairroDAO {
    boolean insert(Bairro bairro);
    List<Bairro> list();
    Bairro getById(Integer id);
    boolean update(Bairro bairro);
    boolean delete(Bairro bairro);
}
