package main.models;

import java.util.Date;

public class Registro {
    private Produto produto;
    private String tipo;
    private Integer quantidade;
    private Date data;

    public Registro() {
        this.produto = new Produto();
        this.tipo = "";
        this.quantidade = 0;
        this.data = new Date("dd/MM/yyyy");
    }

    public Registro(Produto produto, String tipo, Integer quantidade, Date data) {
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
