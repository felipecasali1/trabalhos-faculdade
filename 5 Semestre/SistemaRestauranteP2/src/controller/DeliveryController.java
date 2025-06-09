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
    public DeliveryController() {
        this.interfaceDTO = new DeliveryDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        DeliveryDTO deliveryDTO = (DeliveryDTO) interfaceDTO;
        DeliveryDAO dao = new DeliveryDAOImpl();
        return dao.insert(deliveryDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        DeliveryDTO deliveryDTO = (DeliveryDTO) interfaceDTO;
        DeliveryDAO dao = new DeliveryDAOImpl();
        return dao.update(deliveryDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        DeliveryDTO deliveryDTO = (DeliveryDTO) interfaceDTO;
        DeliveryDAO dao = new DeliveryDAOImpl();
        return dao.delete(deliveryDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        DeliveryDAO dao = new DeliveryDAOImpl();
        for (Delivery d : dao.list()) {
            listDTO.add(DeliveryDTO.toDTO(d));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        DeliveryDAO dao = new DeliveryDAOImpl();
        return DeliveryDTO.toDTO(dao.getById(id));
    }
}
