package controller;

import interfaces.InterfaceController;
import dao.PedidoDAO;
import dao.PedidoDAOImpl;
import dto.PedidoDTO;
import interfaces.InterfaceDTO;
import models.Pedido;

import java.util.LinkedList;
import java.util.List;

public class PedidoController extends InterfaceController {
    public void insert(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.insert(pedidoDTO.buildEntity());
    }

    public void update(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.update(pedidoDTO.buildEntity());
    }

    public void delete(PedidoDTO pedidoDTO) {
        PedidoDAO dao = new PedidoDAOImpl();
        dao.delete(pedidoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        PedidoDAO dao = new PedidoDAOImpl();
        for (Pedido p : dao.list()) {
            listDTO.add(PedidoDTO.buildDTO(p));
        }
        return listDTO;
    }
}
