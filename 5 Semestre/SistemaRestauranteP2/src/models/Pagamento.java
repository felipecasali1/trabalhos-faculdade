package models;

public class Pagamento {
    private int id;
    private Pedido pedido;
    private Cupom cupom;
    private TipoPagamento tipo;
    private PagamentoPix pagamentoPix;
    private PagamentoCartao pagamentoCartao;
    private PagamentoDinheiro pagamentoDinheiro;

    public Pagamento(int id, Pedido pedido, Cupom cupom, TipoPagamento tipo, PagamentoPix pagamentoPix, PagamentoCartao pagamentoCartao, PagamentoDinheiro pagamentoDinheiro) {
        this.id = id;
        this.pedido = pedido;
        this.cupom = cupom;
        this.tipo = tipo;
        this.pagamentoPix = pagamentoPix;
        this.pagamentoCartao = pagamentoCartao;
        this.pagamentoDinheiro = pagamentoDinheiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public PagamentoPix getPagamentoPix() {
        return pagamentoPix;
    }

    public void setPagamentoPix(PagamentoPix pagamentoPix) {
        this.pagamentoPix = pagamentoPix;
    }

    public PagamentoCartao getPagamentoCartao() {
        return pagamentoCartao;
    }

    public void setPagamentoCartao(PagamentoCartao pagamentoCartao) {
        this.pagamentoCartao = pagamentoCartao;
    }

    public PagamentoDinheiro getPagamentoDinheiro() {
        return pagamentoDinheiro;
    }

    public void setPagamentoDinheiro(PagamentoDinheiro pagamentoDinheiro) {
        this.pagamentoDinheiro = pagamentoDinheiro;
    }
}
