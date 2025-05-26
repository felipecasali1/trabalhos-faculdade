package dto;

import models.PagamentoDinheiro;

public class PagamentoDinheiroDTO extends InterfaceDTO {
    public String valorRecebido;
    public String valorTroco;

    public PagamentoDinheiroDTO() {
    }

    public PagamentoDinheiroDTO(String valorRecebido, String valorTroco) {
        this.valorRecebido = valorRecebido;
        this.valorTroco = valorTroco;
    }

    public String getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(String valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public String getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(String valorTroco) {
        this.valorTroco = valorTroco;
    }

    public PagamentoDinheiro builder() {
        PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro();
        pagamentoDinheiro.setValorRecebido(Float.parseFloat(valorRecebido));
        pagamentoDinheiro.setValorTroco(Float.parseFloat(valorTroco));
        return pagamentoDinheiro;
    }
}
