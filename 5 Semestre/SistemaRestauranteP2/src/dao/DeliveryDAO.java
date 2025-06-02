package dao;

import models.Delivery;
import java.util.List;

public interface DeliveryDAO {
    boolean insert(Delivery delivery);
    List<Delivery> list();
    Delivery getById(Integer id);
    boolean update(Delivery delivery);
    boolean delete(Delivery delivery);
}
