package dto;

import interfaces.InterfaceDTO;
import models.PagamentoDinheiro;

public class PagamentoDinheiroDTO extends InterfaceDTO {
    public String valorRecebido;
    public String valorTroco;

    public static PagamentoDinheiroDTO buildDTO(PagamentoDinheiro pagamentoDinheiro) {
        PagamentoDinheiroDTO pdDTO = new PagamentoDinheiroDTO();
        pdDTO.valorRecebido = pagamentoDinheiro.getValorRecebido() + "";
        pdDTO.valorTroco = pagamentoDinheiro.getValorTroco() + "";
        return pdDTO;
    }

    public PagamentoDinheiro buildEntity() {
        PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro();
        pagamentoDinheiro.setValorRecebido(Float.parseFloat(valorRecebido));
        pagamentoDinheiro.setValorTroco(Float.parseFloat(valorTroco));
        return pagamentoDinheiro;
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
