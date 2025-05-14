package dao;

import models.Delivery;
import java.util.List;

public interface DeliveryDAO {
    public abstract void insert(Delivery delivery);
    public abstract List<Delivery> list();
    public abstract Delivery getById(Integer id);
    public abstract void update(Delivery delivery);
    public abstract void delete(Delivery delivery);
}
