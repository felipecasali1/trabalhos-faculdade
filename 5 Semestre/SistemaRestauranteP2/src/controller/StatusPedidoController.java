package controller;

import interfaces.InterfaceController;
import dao.StatusPedidoDAO;
import dao.StatusPedidoDAOImpl;
import dto.StatusPedidoDTO;
import interfaces.InterfaceDTO;
import models.StatusPedido;

import java.util.LinkedList;
import java.util.List;

public class StatusPedidoController extends InterfaceController {
    public StatusPedidoController() {
        this.interfaceDTO = new StatusPedidoDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        StatusPedidoDTO statusPedidoDTO = (StatusPedidoDTO) interfaceDTO;
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return dao.insert(statusPedidoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        StatusPedidoDTO statusPedidoDTO = (StatusPedidoDTO) interfaceDTO;
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return dao.update(statusPedidoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        StatusPedidoDTO statusPedidoDTO = (StatusPedidoDTO) interfaceDTO;
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return dao.delete(statusPedidoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        for (StatusPedido sp : dao.list()) {
            listDTO.add(StatusPedidoDTO.toDTO(sp));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return StatusPedidoDTO.toDTO(dao.getById(id));
    }
}
