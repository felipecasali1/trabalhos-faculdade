package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Reembolso;

public class ReembolsoDTO extends InterfaceDTO {
    public String id;
    public String motivo;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Reembolso) e);
    }

    public static ReembolsoDTO toDTO(Reembolso reembolso) {
        ReembolsoDTO rDTO = new ReembolsoDTO();
        rDTO.id = reembolso.getId() + "";
        rDTO.motivo = reembolso.getMotivo();
        return rDTO;
    }

    @Override
    public Reembolso buildEntity() {
        Reembolso reembolso = new Reembolso();
        reembolso.setId(Integer.parseInt(id));
        reembolso.setMotivo(motivo);
        return reembolso;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Motivo"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, motivo};
    }
}
