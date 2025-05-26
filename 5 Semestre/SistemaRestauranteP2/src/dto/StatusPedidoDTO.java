package dto;

import models.Status;
import models.StatusPedido;

public class StatusPedidoDTO extends InterfaceDTO {
    public String id;
    public String status;

    public StatusPedidoDTO() {
    }

    public StatusPedidoDTO(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusPedido builder() {
        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setId(Integer.parseInt(id));
        statusPedido.setStatus(Status.valueOf(status));
        return statusPedido;
    }
}
