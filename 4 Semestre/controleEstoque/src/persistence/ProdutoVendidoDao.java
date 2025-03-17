package main.persistence;

import main.controller.EstoqueController;
import main.controller.RegistroController;
import main.models.ProdutoVendido;
import main.models.Registro;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ProdutoVendidoDao {
    public static final List<ProdutoVendido> produtosVendidos = new LinkedList<>();

    public static List<ProdutoVendido> getProdutosVendidos() {
        return produtosVendidos;
    }

    public static Boolean salvar(ProdutoVendido produtoVendido) {
        return produtosVendidos.add(produtoVendido);
    }

    public static Boolean excluir(ProdutoVendido produtoVendido) {
        if (produtosVendidos.contains(produtoVendido)) {
            produtosVendidos.remove(produtoVendido);
            return true;
        }
        return false;
    }

    public static void atualizarEstoque(){
        for(ProdutoVendido prodVend : produtosVendidos){
            EstoqueController.removerQuantidade(prodVend.getQuantidade(), prodVend.getProduto());
            Registro registro = new Registro(prodVend.getProduto(), "Saída", prodVend.getQuantidade(), new Date());
            RegistroController.salvar(registro);
        }
    }

    public static void limpar() {
        produtosVendidos.clear();
    }

    public static Boolean isEmpty() {
        return produtosVendidos.isEmpty();
    }
}
