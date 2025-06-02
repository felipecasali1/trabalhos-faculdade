package dao;

import models.Endereco;
import java.util.List;

public interface EnderecoDAO {
    boolean insert(Endereco endereco);
    List<Endereco> list();
    Endereco getById(Integer id);
    boolean update(Endereco endereco);
    boolean delete(Endereco endereco);
}
