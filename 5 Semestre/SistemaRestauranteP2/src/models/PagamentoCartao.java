package models;

public class PagamentoCartao {
    private TipoPagamentoCartao tipo;

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
