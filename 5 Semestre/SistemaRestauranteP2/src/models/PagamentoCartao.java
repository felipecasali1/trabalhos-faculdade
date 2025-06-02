package models;

import interfaces.InterfaceEntity;

public class PagamentoCartao extends InterfaceEntity {
    private TipoPagamentoCartao tipo;

    public PagamentoCartao() {
    }

    public PagamentoCartao(TipoPagamentoCartao tipo) {
        this.tipo = tipo;
    }

    public TipoPagamentoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamentoCartao tipo) {
        this.tipo = tipo;
    }
}
