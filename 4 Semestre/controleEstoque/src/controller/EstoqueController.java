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

    public static Boolean emitirAlerta(Produto produto) {
        return produto != null && EstoqueDao.emitirAlerta(produto);
    }

    public static Boolean emitirAlertaZero(Produto produto) {
        return produto != null && EstoqueDao.emitirAlertaZero(produto);
    }
}
