package main.controller;

import main.persistence.EstoqueDao;
import main.models.Produto;

public class EstoqueController {
    public static Boolean adicionarQuantidade(Integer quantidade, Produto produto) {
        return quantidade > 0 && produto != null && EstoqueDao.adicionarQuantidade(quantidade, produto);
    }

    public static Boolean removerQuantidade(Integer quantidade, Produto produto) {
        return quantidade > 0 && produto != null && EstoqueDao.removerQuantidade(quantidade, produto);
    }

    public static Boolean emitirAlerta() {
        return !possuiEstoque() || !possuiEstoqueMin();
    }

    public static Boolean possuiEstoque() {
        return EstoqueDao.possuiEstoque();
    }

    public static Boolean possuiEstoqueMin() {
        return EstoqueDao.possuiEstoqueMin;
    }
}
