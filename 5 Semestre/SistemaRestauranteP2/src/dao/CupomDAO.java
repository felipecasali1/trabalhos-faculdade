package dao;

import models.Cupom;
import java.util.List;

public interface CupomDAO {
    public abstract void insert(Cupom cupom);
    public abstract List<Cupom> list();
    public abstract Cupom getById(Integer id);
    public abstract void update(Cupom cupom);
    public abstract void delete(Cupom cupom);
}
