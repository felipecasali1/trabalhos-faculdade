package controller;

import models.Produto;

public class ProdutoController {
    private Produto produto;

    public ProdutoController(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
