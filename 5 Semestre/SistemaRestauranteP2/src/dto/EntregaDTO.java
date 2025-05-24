package dto;

import models.Entrega;
import models.TipoEntrega;

public class EntregaDTO extends InterfaceDTO {
    public String id;
    public ClienteDTO clienteDTO;
    public String tipoEntrega;
    public DeliveryDTO deliveryDTO;
    public PedidoDTO pedidoDTO;

    public EntregaDTO() {
    }

    public EntregaDTO(String id, ClienteDTO clienteDTO, String tipoEntrega, DeliveryDTO deliveryDTO, PedidoDTO pedidoDTO) {
        this.id = id;
        this.clienteDTO = clienteDTO;
        this.tipoEntrega = tipoEntrega;
        this.deliveryDTO = deliveryDTO;
        this.pedidoDTO = pedidoDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public DeliveryDTO getDeliveryDTO() {
        return deliveryDTO;
    }

    public void setDeliveryDTO(DeliveryDTO deliveryDTO) {
        this.deliveryDTO = deliveryDTO;
    }

    public PedidoDTO getPedidoDTO() {
        return pedidoDTO;
    }

    public void setPedidoDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public Entrega builder() {
        Entrega entrega = new Entrega();
        entrega.setId(Integer.parseInt(id));
        entrega.setCliente(clienteDTO.builder());
        entrega.setTipo(TipoEntrega.valueOf(tipoEntrega));
        entrega.setDelivery(deliveryDTO.builder());
        entrega.setPedido(pedidoDTO.builder());
        return entrega;
    }
}
