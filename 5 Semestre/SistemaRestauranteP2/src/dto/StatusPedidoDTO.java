package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Status;
import models.StatusPedido;

public class StatusPedidoDTO extends InterfaceDTO {
    public String status;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((StatusPedido) e);
    }

    public static StatusPedidoDTO toDTO(StatusPedido statusPedido) {
        StatusPedidoDTO spDTO = new StatusPedidoDTO();
        spDTO.id = statusPedido.getId() + "";
        spDTO.status = statusPedido.getStatus().toString();
        return spDTO;
    }

    @Override
    public StatusPedido buildEntity() {
        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setId(Integer.parseInt(id));
        statusPedido.setStatus(Status.valueOf(status));
        return statusPedido;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Status"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, status};
    }

    @Override
    public String toString() {
        return status;
    }
}
