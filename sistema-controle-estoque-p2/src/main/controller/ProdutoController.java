package main.controller;

import main.models.Produto;
import main.persistence.ProdutoDao;

public class ProdutoController {
    public static Boolean salvar(Produto produto) {
        return produto != null && ProdutoDao.salvar(produto);
    }

    public static Boolean excluir(Produto produto) {
        return produto != null && ProdutoDao.excluir(produto);
    }

    public static Boolean editar(Integer codigo, Produto produto) {
        return produto != null && ProdutoDao.editar(codigo, produto);
    }

    public static Boolean verificarCodigo(Integer codigo) {
        return codigo != null && ProdutoDao.produtoExiste(codigo);
    }

    public static String toString(Produto produto) {
        if (produto != null) {
            return "Produto: " + produto.getNome() +
                    "\nCódigo: " + produto.getCodigo() +
                    "\nPreço: R$" + produto.getPreco() +
                    "\nCategoria: " + produto.getCategoria() +
                    "\nFornecedor: " + produto.getFornecedor() +
                    "\nQuantidade em estoque: " + produto.getEstoque().getQuantidade() +
                    "\nQuantidade mínima: " + produto.getEstoque().getQuantidadeMinima();
        }
        return null;
    }

    public static String toStringRelatorio(Produto produto) {
        if (produto != null) {
            return "Produto: " + produto.getNome() +
                    " | Código: " + produto.getCodigo() +
                    " | Preço: R$" + produto.getPreco() +
                    " | Fornecedor: " + produto.getFornecedor() +
                    " | Quantidade em estoque: " + produto.getEstoque().getQuantidade() +
                    " | Quantidade mínima: " + produto.getEstoque().getQuantidadeMinima();
        }
        return null;
    }
}
