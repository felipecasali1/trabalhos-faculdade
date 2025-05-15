package dao;

import models.Reembolso;

import java.util.List;

public interface ReembolsoDAO {
    void insert(Reembolso reembolso);
    List<Reembolso> list();
    Reembolso getById(Integer id);
    void update(Reembolso reembolso);
    void delete(Reembolso reembolso);
}
