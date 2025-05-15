package dao;

import models.Endereco;
import java.util.List;

public interface EnderecoDAO {
    void insert(Endereco endereco);
    List<Endereco> list();
    Endereco getById(Integer id);
    void update(Endereco endereco);
    void delete(Endereco endereco);
}
