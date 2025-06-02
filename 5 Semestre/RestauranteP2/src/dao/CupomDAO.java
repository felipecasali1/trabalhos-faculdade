package dao;

import models.Cupom;
import java.util.List;

public interface CupomDAO {
    void insert(Cupom cupom);
    List<Cupom> list();
    Cupom getById(Integer id);
    void update(Cupom cupom);
    void delete(Cupom cupom);
}
