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
    public void insert(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.insert(statusPedidoDTO.buildEntity());
    }

    public void update(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.update(statusPedidoDTO.buildEntity());
    }

    public void delete(StatusPedidoDTO statusPedidoDTO) {
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        dao.delete(statusPedidoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        StatusPedidoDAO dao = new StatusPedidoDAOImpl();
        for (StatusPedido sp : dao.list()) {
            listDTO.add(StatusPedidoDTO.buildDTO(sp));
        }
        return listDTO;
    }
}
