package models;

public class PagamentoDinheiro {
    private float valorRecebido;
    private float valorTroco;

    public PagamentoDinheiro(int id, float valorRecebido, float valorTroco) {
        this.valorRecebido = valorRecebido;
        this.valorTroco = valorTroco;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public float getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(float valorTroco) {
        this.valorTroco = valorTroco;
    }
}
