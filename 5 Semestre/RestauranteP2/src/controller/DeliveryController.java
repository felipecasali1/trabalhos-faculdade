package controller;

import interfaces.InterfaceController;
import dao.DeliveryDAO;
import dao.DeliveryDAOImpl;
import dto.DeliveryDTO;
import interfaces.InterfaceDTO;
import models.Delivery;

import java.util.LinkedList;
import java.util.List;

public class DeliveryController extends InterfaceController {
    public void insert(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.insert(deliveryDTO.buildEntity());
    }

    public void update(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.update(deliveryDTO.buildEntity());
    }

    public void delete(DeliveryDTO deliveryDTO) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        dao.delete(deliveryDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        DeliveryDAO dao = new DeliveryDAOImpl();
        for (Delivery d : dao.list()) {
            listDTO.add(DeliveryDTO.buildDTO(d));
        }
        return listDTO;
    }
}
