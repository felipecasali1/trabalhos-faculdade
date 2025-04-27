package models;

public class Pagamento {
    private int id;
    private MetodoPagamento metodo;
    private Cupom cupom;
    private Pedido pedido;

    public Pagamento(int id, MetodoPagamento metodo, Cupom cupom, Pedido pedido) {
        this.id = id;
        this.metodo = metodo;
        this.cupom = cupom;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MetodoPagamento getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
