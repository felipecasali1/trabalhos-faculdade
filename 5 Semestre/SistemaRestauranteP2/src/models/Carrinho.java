package models;

import java.util.List;

public class Carrinho {
    private int id;
    private int quantidade;
    private List<Produto> produtos;
    private IngredienteEscolha ingEscolha;

    public Carrinho(int id, int quantidade, List<Produto> produtos, IngredienteEscolha ingEscolha) {
        this.id = id;
        this.quantidade = quantidade;
        this.produtos = produtos;
        this.ingEscolha = ingEscolha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProduto() {
        return produtos;
    }

    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public IngredienteEscolha getIngEscolha() {
        return ingEscolha;
    }

    public void setIngEscolha(IngredienteEscolha ingEscolha) {
        this.ingEscolha = ingEscolha;
    }
}
