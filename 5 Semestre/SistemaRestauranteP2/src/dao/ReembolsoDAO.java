package dao;

import models.Reembolso;

import java.util.List;

public interface ReembolsoDAO {
    public abstract void insert(Reembolso reembolso);
    public abstract List<Reembolso> list();
    public abstract Reembolso getById(Integer id);
    public abstract void update(Reembolso reembolso);
    public abstract void delete(Reembolso reembolso);
}
