package controller;

import models.Produto;
import persistence.ProdutoDao;

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

    public static Boolean salvar(Produto produto) {
        if(produto != null && ProdutoDao.buscarProduto(produto.getCodigo()) == null) {
            ProdutoDao.salvar(produto);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Produto produto) {
        if(produto != null && ProdutoDao.contains(produto)){
            ProdutoDao.excluir(produto);
            return true;
        }
        return false;
    }

    public static Boolean editar(Integer codigo, Produto produto) {
        if (produto != null) {
            Produto prod = ProdutoDao.buscarProduto(codigo);
            if (prod != null) {
                ProdutoDao.editar(codigo, produto);
                return true;
            }
        }
        return false;
    }

    public static String toString(Produto produto) {
        if (produto != null) {
            return "Produto: " + produto.getNome() +
                    "\nCódigo: " + produto.getCodigo() +
                    "\nPreço: " + produto.getPreco() +
                    "\nCategoria: " + produto.getCategoria() +
                    "\nFornecedor: " + produto.getFornecedor() +
                    "\nQuantidade em estoque: " + produto.getEstoque().getQuantidade() +
                    "\nQuantidade mínima: " + produto.getEstoque().getQuantidadeMinima();
        }
        return null;
    }
}
