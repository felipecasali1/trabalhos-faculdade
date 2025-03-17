package main.controller;

import main.models.ProdutoVendido;
import main.persistence.ProdutoVendidoDao;


public class ProdutoVendidoController {
    public static Boolean salvar(ProdutoVendido produtoVendido){
        return produtoVendido != null && ProdutoVendidoDao.salvar(produtoVendido);
    }

    public static Boolean excluir(ProdutoVendido produtoVendido){
        return produtoVendido != null && ProdutoVendidoDao.excluir(produtoVendido);
    }

    public static void limpar(){
        ProdutoVendidoDao.limpar();
    }

    public static void atualizarEstoque() {
        ProdutoVendidoDao.atualizarEstoque();
    }

    public static String toString(ProdutoVendido produtoVendido) {
        return ProdutoController.toString(produtoVendido.getProduto()) + "\nQuantidade a ser vendida: " + produtoVendido.getQuantidade();
    }
}
