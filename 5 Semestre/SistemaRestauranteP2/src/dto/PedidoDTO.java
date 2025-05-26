package dto;

import models.Pedido;

import java.sql.Timestamp;

public class PedidoDTO extends InterfaceDTO {
    public String id;
    public String data;
    public ClienteDTO clienteDTO;
    public CarrinhoDTO carrinhoDTO;
    public StatusPedidoDTO statusPedidoDTO;
    public ReembolsoDTO reembolsoDTO;

    public PedidoDTO() {
    }

    public PedidoDTO(String id, String data, ClienteDTO clienteDTO, CarrinhoDTO carrinhoDTO, StatusPedidoDTO statusPedidoDTO, ReembolsoDTO reembolsoDTO) {
        this.id = id;
        this.data = data;
        this.clienteDTO = clienteDTO;
        this.carrinhoDTO = carrinhoDTO;
        this.statusPedidoDTO = statusPedidoDTO;
        this.reembolsoDTO = reembolsoDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public CarrinhoDTO getCarrinhoDTO() {
        return carrinhoDTO;
    }

    public void setCarrinhoDTO(CarrinhoDTO carrinhoDTO) {
        this.carrinhoDTO = carrinhoDTO;
    }

    public StatusPedidoDTO getStatusPedidoDTO() {
        return statusPedidoDTO;
    }

    public void setStatusPedidoDTO(StatusPedidoDTO statusPedidoDTO) {
        this.statusPedidoDTO = statusPedidoDTO;
    }

    public ReembolsoDTO getReembolsoDTO() {
        return reembolsoDTO;
    }

    public void setReembolsoDTO(ReembolsoDTO reembolsoDTO) {
        this.reembolsoDTO = reembolsoDTO;
    }

    public Pedido builder() {
        Pedido pedido = new Pedido();
        pedido.setId(Integer.parseInt(id));
        pedido.setData(Timestamp.valueOf(data));
        pedido.setCliente(clienteDTO.builder());
        pedido.setCarrinho(carrinhoDTO.builder());
        pedido.setStatus(statusPedidoDTO.builder());
        pedido.setReembolso(reembolsoDTO.builder());
        return pedido;
    }
}
