package main.controller;

import main.models.Produto;
import main.persistence.ProdutoDao;

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
        return produto != null && ProdutoDao.salvar(produto);
    }

    public static Boolean excluir(Produto produto) {
        return produto != null && ProdutoDao.excluir(produto);
    }

    public static Boolean editar(Integer codigo, Produto produto) {
        return produto != null && ProdutoDao.editar(codigo, produto);
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

    public static Boolean verificarCodigo(Integer codigo) {
        return ProdutoDao.produtoExiste(codigo);
    }
}
