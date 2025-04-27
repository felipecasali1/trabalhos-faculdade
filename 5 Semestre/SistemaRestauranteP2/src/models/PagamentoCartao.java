package models;

public class PagamentoCartao extends MetodoPagamento {
    private String numero;
    private String cvv;
    private TipoPagamentoCartao tipo;

    public PagamentoCartao(String numero, String cvv, TipoPagamentoCartao tipo, int id) {
        super(id);
        this.numero = numero;
        this.cvv = cvv;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public TipoPagamentoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamentoCartao tipo) {
        this.tipo = tipo;
    }
}
