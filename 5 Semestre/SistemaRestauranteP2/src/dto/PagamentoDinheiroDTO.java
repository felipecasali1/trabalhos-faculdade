package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.PagamentoDinheiro;

public class PagamentoDinheiroDTO extends InterfaceDTO {
    public String valorRecebido;
    public String valorTroco;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((PagamentoDinheiro) e);
    }

    public static PagamentoDinheiroDTO toDTO(PagamentoDinheiro pagamentoDinheiro) {
        PagamentoDinheiroDTO pdDTO = new PagamentoDinheiroDTO();
        pdDTO.valorRecebido = pagamentoDinheiro.getValorRecebido() + "";
        pdDTO.valorTroco = pagamentoDinheiro.getValorTroco() + "";
        return pdDTO;
    }

    @Override
    public PagamentoDinheiro buildEntity() {
        PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro();
        pagamentoDinheiro.setValorRecebido(Float.parseFloat(valorRecebido));
        pagamentoDinheiro.setValorTroco(Float.parseFloat(valorTroco));
        return pagamentoDinheiro;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Valor Recebido", "Valor Troco"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{valorRecebido, valorTroco};
    }
}
