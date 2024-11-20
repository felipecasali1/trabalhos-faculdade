package main.controller;

import main.models.ProdutoVendido;
import main.models.Venda;
import main.persistence.VendaDao;

public class VendaController {
//    public static String gerarRelatorio(Venda[] vendas) {
//        String relatorio = "Relatório de Vendas:\n\n";
//        for (Venda venda : vendas) {
//            relatorio += "Data: " + venda.getData() + "\n";
//            relatorio += "Produtos:\n";
//
//            for (ProdutoVendido prodVend : venda.getProdutosVendidos()) {
//                relatorio += prodVend.getQuantidade() + " - " + prodVend.getProduto().getNome() + "\n";
//            }
//            relatorio += "Quantidade total: " + venda.getQuantidadeTotal() + "\n";
//            relatorio += "Valor total: " + venda.getValorTotal() + "\n\n";
//        }
//        return relatorio;
//    }

    public static Boolean salvar(Venda venda) {
        return venda != null && venda.getProdutosVendidos() != null && VendaDao.salvar(venda);
    }

    public static String toString(Venda venda) {
        return "Cliente: " + venda.getCliente().getNome() +
                "\nCPF: " + venda.getCliente().getCpf() +
                "\nData: " + venda.getData() +
                "\nValor Total: " + venda.getValorTotal() +
                "\nQuantidade Total: " + venda.getQuantidadeTotal() +
                "\nProdutos Vendidos: \n" + venda.getProdutosVendidos();
    }
}
