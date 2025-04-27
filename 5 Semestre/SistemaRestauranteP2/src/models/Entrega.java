package models;

public class Entrega {
    private int id;
    private Cliente cliente;
    private TipoEntrega tipo;
    private Delivery delivery;
    private Pedido pedido;
    private StatusEntrega status;

    public Entrega(int id, Cliente cliente, TipoEntrega tipo, Delivery delivery, Pedido pedido, StatusEntrega status) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.delivery = delivery;
        this.pedido = pedido;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEntrega getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrega tipo) {
        this.tipo = tipo;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
