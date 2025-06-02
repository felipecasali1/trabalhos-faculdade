package dto;

import interfaces.InterfaceDTO;
import models.PagamentoPix;

public class PagamentoPixDTO extends InterfaceDTO {
    public String chavePix;

    public static PagamentoPixDTO buildDTO(PagamentoPix pagamentoPix) {
        PagamentoPixDTO ppDTO = new PagamentoPixDTO();
        ppDTO.chavePix = pagamentoPix.getChavePix();
        return ppDTO;
    }

    public PagamentoPix buildEntity() {
        PagamentoPix pagamentoPix = new PagamentoPix();
        pagamentoPix.setChavePix(chavePix);
        return pagamentoPix;
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
