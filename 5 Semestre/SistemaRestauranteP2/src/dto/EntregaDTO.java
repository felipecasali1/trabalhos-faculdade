package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Entrega;
import models.TipoEntrega;

public class EntregaDTO extends InterfaceDTO {
    public String id;
    public ClienteDTO clienteDTO;
    public String tipoEntrega;
    public DeliveryDTO deliveryDTO;
    public PedidoDTO pedidoDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Entrega) e);
    }

    public static EntregaDTO toDTO(Entrega entrega) {
        EntregaDTO eDTO = new EntregaDTO();
        eDTO.id = entrega.getId() + "";
        eDTO.clienteDTO = ClienteDTO.toDTO(entrega.getCliente());
        eDTO.tipoEntrega = entrega.getTipo().toString();
        eDTO.deliveryDTO = DeliveryDTO.toDTO(entrega.getDelivery());
        eDTO.pedidoDTO = PedidoDTO.toDTO(entrega.getPedido());
        return eDTO;
    }

    @Override
    public Entrega buildEntity() {
        Entrega entrega = new Entrega();
        entrega.setId(Integer.parseInt(id));
        entrega.setCliente(clienteDTO.buildEntity());
        entrega.setTipo(TipoEntrega.valueOf(tipoEntrega));
        entrega.setDelivery(deliveryDTO.buildEntity());
        entrega.setPedido(pedidoDTO.buildEntity());
        return entrega;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Cliente", "Tipo Entrega", "Delivery", "Pedido"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, clienteDTO.nome, tipoEntrega, deliveryDTO.enderecoDTO.bairroDTO.nome, pedidoDTO.statusPedidoDTO.status};
    }
}
