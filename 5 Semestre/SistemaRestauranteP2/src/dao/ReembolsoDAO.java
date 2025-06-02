package dao;

import models.Reembolso;

import java.util.List;

public interface ReembolsoDAO {
    boolean insert(Reembolso reembolso);
    List<Reembolso> list();
    Reembolso getById(Integer id);
    boolean update(Reembolso reembolso);
    boolean delete(Reembolso reembolso);
}
