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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        PedidoDTO pedidoDTO = (PedidoDTO) interfaceDTO;
        PedidoDAO dao = new PedidoDAOImpl();
        return dao.insert(pedidoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        PedidoDTO pedidoDTO = (PedidoDTO) interfaceDTO;
        PedidoDAO dao = new PedidoDAOImpl();
        return dao.update(pedidoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        PedidoDTO pedidoDTO = (PedidoDTO) interfaceDTO;
        PedidoDAO dao = new PedidoDAOImpl();
        return dao.delete(pedidoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        PedidoDAO dao = new PedidoDAOImpl();
        for (Pedido p : dao.list()) {
            listDTO.add(PedidoDTO.toDTO(p));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        PedidoDAO dao = new PedidoDAOImpl();
        return PedidoDTO.toDTO(dao.getById(id));
    }
}
