package dto;

import models.Reembolso;

public class ReembolsoDTO extends InterfaceDTO {
    public String id;
    public String motivo;

    public ReembolsoDTO() {
    }

    public ReembolsoDTO(String id, String motivo) {
        this.id = id;
        this.motivo = motivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Reembolso builder() {
        Reembolso reembolso = new Reembolso();
        reembolso.setId(Integer.parseInt(id));
        reembolso.setMotivo(motivo);
        return reembolso;
    }
}
