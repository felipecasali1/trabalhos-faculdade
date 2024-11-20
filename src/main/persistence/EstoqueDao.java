package main.persistence;

import main.models.Produto;

public class EstoqueDao {
    public static Boolean adicionarQuantidade(Integer quantidade, Produto produto) {
        if (ProdutoDao.contains(produto)) {
            Produto prod = ProdutoDao.buscarProduto(produto.getCodigo());
                if (prod != null) {
                    prod.getEstoque().setQuantidade(prod.getEstoque().getQuantidade() + quantidade);
                    return true;
                }
        }
        return false;
    }

    public static Boolean removerQuantidade(Integer quantidade, Produto produto) {
        if (ProdutoDao.contains(produto)) {
            Produto prod = ProdutoDao.buscarProduto(produto.getCodigo());
            if (prod != null) {
                prod.getEstoque().setQuantidade(prod.getEstoque().getQuantidade() - quantidade);
                return true;
            }
        }
        return false;
    }

    public static Boolean emitirAlerta(Produto produto) {
        return produto.getEstoque().getQuantidade() < produto.getEstoque().getQuantidadeMinima();
    }
}
