package models;

import interfaces.InterfaceEntity;

import java.sql.Timestamp;

public class Pedido extends InterfaceEntity {
    private int id;
    private Timestamp data;
    private Cliente cliente;
    private Carrinho carrinho;
    private StatusPedido status;
    private Reembolso reembolso;

    public Pedido() {
    }

    public Pedido(int id, Timestamp data, Cliente cliente, Carrinho carrinho, StatusPedido status, Reembolso reembolso) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.status = status;
        this.reembolso = reembolso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
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

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }
}
