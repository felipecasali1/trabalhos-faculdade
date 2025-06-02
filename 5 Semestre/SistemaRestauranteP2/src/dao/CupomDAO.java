package dao;

import models.Cupom;
import java.util.List;

public interface CupomDAO {
    boolean insert(Cupom cupom);
    List<Cupom> list();
    Cupom getById(Integer id);
    boolean update(Cupom cupom);
    boolean delete(Cupom cupom);
}
