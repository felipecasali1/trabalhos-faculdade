package dao;

import models.Endereco;
import java.util.List;

public interface EnderecoDAO {
    public abstract void insert(Endereco endereco);
    public abstract List<Endereco> list();
    public abstract Endereco getById(Integer id);
    public abstract void update(Endereco endereco);
    public abstract void delete(Endereco endereco);
}
