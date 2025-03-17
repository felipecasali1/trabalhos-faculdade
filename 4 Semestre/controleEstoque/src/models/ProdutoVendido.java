package main.models;

public class ProdutoVendido {
    private Produto produto;
    private Integer quantidade;

    public ProdutoVendido() {
        this.produto = new Produto();
        this.quantidade = 0;
    }

    public ProdutoVendido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + " - Quantidade: " + quantidade;
    }
}
