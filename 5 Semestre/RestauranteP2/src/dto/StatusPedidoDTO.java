package dto;

import interfaces.InterfaceDTO;
import models.Status;
import models.StatusPedido;

public class StatusPedidoDTO extends InterfaceDTO {
    public String id;
    public String status;

    public static StatusPedidoDTO buildDTO(StatusPedido statusPedido) {
        StatusPedidoDTO spDTO = new StatusPedidoDTO();
        spDTO.id = statusPedido.getId() + "";
        spDTO.status = statusPedido.getStatus().toString();
        return spDTO;
    }

    public StatusPedido buildEntity() {
        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setId(Integer.parseInt(id));
        statusPedido.setStatus(Status.valueOf(status));
        return statusPedido;
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
