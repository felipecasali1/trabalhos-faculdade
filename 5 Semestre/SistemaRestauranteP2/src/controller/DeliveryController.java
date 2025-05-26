package controller;

import dao.DeliveryDAO;
import dao.DeliveryDAOImpl;
import dto.DeliveryDTO;
import models.Delivery;

import java.util.List;

public class DeliveryController extends InterfaceController {
    public void insert(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.insert(deliveryDTO.builder());
    }

    public void update(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.update(deliveryDTO.builder());
    }

    public void delete(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.delete(deliveryDTO.builder());
    }

    public List<Delivery> list() {
        //Corrigir para retornar List<DeliveryDTO>
        DeliveryDAO dao = new DeliveryDAOImpl();
        return dao.list();
    }
}
