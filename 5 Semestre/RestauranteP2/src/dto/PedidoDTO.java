package dto;

import interfaces.InterfaceDTO;
import models.Pedido;

import java.sql.Timestamp;

public class PedidoDTO extends InterfaceDTO {
    public String id;
    public String data;
    public ClienteDTO clienteDTO;
    public CarrinhoDTO carrinhoDTO;
    public StatusPedidoDTO statusPedidoDTO;
    public ReembolsoDTO reembolsoDTO;

    public static PedidoDTO buildDTO(Pedido pedido) {
        PedidoDTO pDTO = new PedidoDTO();
        pDTO.id = pedido.getId() + "";
        pDTO.data = pedido.getData().toString();
        pDTO.clienteDTO = ClienteDTO.buildDTO(pedido.getCliente());
        pDTO.carrinhoDTO = CarrinhoDTO.buildDTO(pedido.getCarrinho());
        pDTO.statusPedidoDTO = StatusPedidoDTO.buildDTO(pedido.getStatus());
        pDTO.reembolsoDTO = ReembolsoDTO.buildDTO(pedido.getReembolso());
        return pDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
