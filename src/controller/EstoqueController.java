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
        if(quantidade > 0) {
            estoque.adicionarQuantidade(quantidade);
        }
    }

    public void removerQuantidade(Integer quantidade) {
        if(quantidade > 0 && quantidade <= estoque.getQuantidade()) {
            estoque.removerQuantidade(quantidade);
        }
    }

    public Boolean emitirAlerta() {
        return estoque.emitirAlerta();
    }

    public Boolean possuiEstoque() {
        return estoque.possuiEstoque();
    }
}
