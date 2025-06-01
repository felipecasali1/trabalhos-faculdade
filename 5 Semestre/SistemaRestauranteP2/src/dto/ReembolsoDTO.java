package dto;

import interfaces.InterfaceDTO;
import models.Reembolso;

public class ReembolsoDTO extends InterfaceDTO {
    public String id;
    public String motivo;

    public static ReembolsoDTO buildDTO(Reembolso reembolso) {
        ReembolsoDTO rDTO = new ReembolsoDTO();
        rDTO.id = reembolso.getId() + "";
        rDTO.motivo = reembolso.getMotivo();
        return rDTO;
    }

    public Reembolso buildEntity() {
        Reembolso reembolso = new Reembolso();
        reembolso.setId(Integer.parseInt(id));
        reembolso.setMotivo(motivo);
        return reembolso;
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
