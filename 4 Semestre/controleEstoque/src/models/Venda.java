package main.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Venda {
    private Date data;
    private List<ProdutoVendido> produtosVendidos;
    private Integer quantidadeTotal;
    private Float valorTotal;
    private Cliente cliente;
    private Vendedor vendedor;

    public Venda() {
        this.data = new Date();
        this.produtosVendidos = new LinkedList<>();
        this.quantidadeTotal = 0;
        this.valorTotal = 0.0F;
        this.cliente = new Cliente();
        this.vendedor = new Vendedor();
    }

    public Venda(Date data, List<ProdutoVendido> produtosVendidos, Cliente cliente, Vendedor vendedor) {
        this.data = data;
        this.produtosVendidos = produtosVendidos;
        this.quantidadeTotal = calcularQuantidadeTotal(produtosVendidos);
        this.valorTotal = calcularValorTotal(produtosVendidos);
        this.cliente = cliente;
        this.vendedor = vendedor;
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
        this.quantidadeTotal = calcularQuantidadeTotal(produtosVendidos);
        this.valorTotal = calcularValorTotal(produtosVendidos);
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    private Integer calcularQuantidadeTotal(List<ProdutoVendido> produtosVendidos) {
        Integer quant = 0;
        for(ProdutoVendido prodVend : produtosVendidos) {
            quant += prodVend.getQuantidade();
        }
        return quant;
    }

    private Float calcularValorTotal(List<ProdutoVendido> produtosVendidos) {
        Float valorT = 0.0F;
        for(ProdutoVendido prodVend : produtosVendidos) {
            valorT += prodVend.getProduto().getPreco() * prodVend.getQuantidade();
        }
        return valorT;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return cliente.getNome() + " - " + sdf.format(data);
    }
}
