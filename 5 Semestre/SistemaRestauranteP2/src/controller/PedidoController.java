package controller;

import dao.PedidoDAO;
import dao.PedidoDAOImpl;
import dto.PedidoDTO;
import models.Pedido;

import java.util.List;

public class PedidoController extends InterfaceController {
    public void insert(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.insert(pedidoDTO.builder());
    }

    public void update(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.update(pedidoDTO.builder());
    }

    public void delete(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.delete(pedidoDTO.builder());
    }

    public List<Pedido> list() {
        PedidoDAO dao = new PedidoDAOImpl();
        return dao.list();
    }
}
