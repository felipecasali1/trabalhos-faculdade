package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.PagamentoPix;

public class PagamentoPixDTO extends InterfaceDTO {
    public String chavePix;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((PagamentoPix) e);
    }

    public static PagamentoPixDTO toDTO(PagamentoPix pagamentoPix) {
        PagamentoPixDTO ppDTO = new PagamentoPixDTO();
        ppDTO.chavePix = pagamentoPix.getChavePix();
        return ppDTO;
    }

    @Override
    public PagamentoPix buildEntity() {
        PagamentoPix pagamentoPix = new PagamentoPix();
        pagamentoPix.setChavePix(chavePix);
        return pagamentoPix;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Chave Pix"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{chavePix};
    }
}
