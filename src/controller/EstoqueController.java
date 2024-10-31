package controller;

import models.Estoque;

public class EstoqueController {
    private Estoque estoque;

    public EstoqueController(Estoque estoque) {
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void adicionarQuantidade(Integer quantidade) {
        estoque.adicionarQuantidade(quantidade);
    }

    public void removerQuantidade(Integer quantidade) {
        estoque.removerQuantidade(quantidade);
    }
}
