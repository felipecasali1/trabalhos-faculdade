package dto;

import interfaces.InterfaceDTO;
import models.Entrega;
import models.TipoEntrega;

public class EntregaDTO extends InterfaceDTO {
    public String id;
    public ClienteDTO clienteDTO;
    public String tipoEntrega;
    public DeliveryDTO deliveryDTO;
    public PedidoDTO pedidoDTO;

    public static EntregaDTO buildDTO(Entrega entrega) {
        EntregaDTO eDTO = new EntregaDTO();
        eDTO.id = entrega.getId() + "";
        eDTO.clienteDTO = ClienteDTO.buildDTO(entrega.getCliente());
        eDTO.tipoEntrega = entrega.getTipo().toString();
        eDTO.deliveryDTO = DeliveryDTO.buildDTO(entrega.getDelivery());
        eDTO.pedidoDTO = PedidoDTO.buildDTO(entrega.getPedido());
        return eDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
