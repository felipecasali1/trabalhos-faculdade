package controller;

import dao.StatusPedidoDAO;
import dao.StatusPedidoDAOImpl;
import dto.StatusPedidoDTO;
import models.StatusPedido;

import java.util.List;

public class StatusPedidoController extends InterfaceController {
    public void insert(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.insert(statusPedidoDTO.builder());
    }

    public void update(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.update(statusPedidoDTO.builder());
    }

    public void delete(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.delete(statusPedidoDTO.builder());
    }

    public List<StatusPedido> list() {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        return dao.list();
    }
}
