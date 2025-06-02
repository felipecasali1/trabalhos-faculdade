package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Pedido;

import java.sql.Timestamp;

public class PedidoDTO extends InterfaceDTO {
    public String id;
    public String data;
    public ClienteDTO clienteDTO;
    public CarrinhoDTO carrinhoDTO;
    public StatusPedidoDTO statusPedidoDTO;
    public ReembolsoDTO reembolsoDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Pedido) e);
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO pDTO = new PedidoDTO();
        pDTO.id = pedido.getId() + "";
        pDTO.data = pedido.getData().toString();
        pDTO.clienteDTO = ClienteDTO.toDTO(pedido.getCliente());
        pDTO.carrinhoDTO = CarrinhoDTO.toDTO(pedido.getCarrinho());
        pDTO.statusPedidoDTO = StatusPedidoDTO.toDTO(pedido.getStatus());
        pDTO.reembolsoDTO = ReembolsoDTO.toDTO(pedido.getReembolso());
        return pDTO;
    }

    @Override
    public Pedido buildEntity() {
        Pedido pedido = new Pedido();
        pedido.setId(Integer.parseInt(id));
        pedido.setData(Timestamp.valueOf(data));
        pedido.setCliente(clienteDTO.buildEntity());
        pedido.setCarrinho(carrinhoDTO.buildEntity());
        pedido.setStatus(statusPedidoDTO.buildEntity());
        pedido.setReembolso(reembolsoDTO.buildEntity());
        return pedido;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Data", "Cliente", "Carrinho", "Status Pedido", "Reembolso"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, data, clienteDTO.nome, carrinhoDTO.id, statusPedidoDTO.status, reembolsoDTO.motivo};
    }
}
