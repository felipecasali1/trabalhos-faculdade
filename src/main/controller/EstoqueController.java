package main.controller;

import main.persistence.EstoqueDao;
import main.models.Produto;

public class EstoqueController {
    public static Boolean adicionarQuantidade(Integer quantidade, Produto produto) {
        return quantidade > 0 && produto != null && EstoqueDao.adicionarQuantidade(quantidade, produto);
    }


}
