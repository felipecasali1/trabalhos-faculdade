package models;

import java.time.LocalDateTime;

public class Pedido {
    private int id;
    private LocalDateTime data;
    private Cliente cliente;
    private Carrinho carrinho;
    private StatusPedido status;
    private Entrega entrega;
    private Reembolso reembolso;

    public Pedido(int id, LocalDateTime data, Cliente cliente, Carrinho carrinho, StatusPedido status, Entrega entrega, Reembolso reembolso) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.status = status;
        this.entrega = entrega;
        this.reembolso = reembolso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }
}
