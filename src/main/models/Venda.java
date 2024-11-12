package main.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Venda {
    private Date data;
    private List<ProdutoVendido> produtosVendidos;
    private Integer quantidadeTotal;
    private Float valorTotal;
    private Cliente cliente;

    public Venda() {
        this.data = new Date();
        this.produtosVendidos = new LinkedList<>();
        this.quantidadeTotal = 0;
        this.valorTotal = 0.0F;
        this.cliente = new Cliente();
    }

    public Venda(Date data, List<ProdutoVendido> produtosVendidos, Integer quantidadeTotal, Float valorTotal, Cliente cliente) {
        this.data = data;
        this.produtosVendidos = produtosVendidos;
        this.quantidadeTotal = calcularQuantidadeTotal();
        this.valorTotal = calcularValorTotal();
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoVendido> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutoVendido> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
        this.quantidadeTotal = calcularQuantidadeTotal();
        this.valorTotal = calcularValorTotal();
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private Integer calcularQuantidadeTotal() {
        Integer quant = 0;
        for(ProdutoVendido prodVend : produtosVendidos) {
            quant += prodVend.getQuantidade();
        }
        return quant;
    }

    private Float calcularValorTotal() {
        Float valorT = 0.0F;
        for(ProdutoVendido prodVend : produtosVendidos) {
            valorT += prodVend.getProduto().getPreco() * prodVend.getQuantidade();
        }
        return valorT;
    }
}
