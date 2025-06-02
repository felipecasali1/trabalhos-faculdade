package dao;

import models.Delivery;
import java.util.List;

public interface DeliveryDAO {
    void insert(Delivery delivery);
    List<Delivery> list();
    Delivery getById(Integer id);
    void update(Delivery delivery);
    void delete(Delivery delivery);
}
