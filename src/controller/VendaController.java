package controller;

import models.ProdutoVendido;
import models.Venda;
import persistence.VendaDao;

public class VendaController {
    private Venda venda;

    public VendaController() {
        this.venda = new Venda();
    }

    public VendaController(Venda venda) {
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public static String gerarRelatorio(Venda[] vendas) {
        String relatorio = "Relatório de Vendas:\n\n";
        for (Venda venda : vendas) {
            relatorio += "Data: " + venda.getData() + "\n";
            relatorio += "Produtos:\n";

            for (ProdutoVendido prodVend : venda.getProdutosVendidos()) {
                relatorio += prodVend.getQuantidade() + " - " + prodVend.getProduto().getNome() + "\n";
            }
            relatorio += "Quantidade total: " + venda.getQuantidadeTotal() + "\n";
            relatorio += "Valor total: " + venda.getValorTotal() + "\n\n";
        }
        return relatorio;
    }

    private Boolean estoqueSuficiente() {
        for (ProdutoVendido prodVend : venda.getProdutosVendidos()) {
            if (prodVend.getProduto().getEstoque().getQuantidade() < prodVend.getQuantidade()) {
                return false;
            }
        }
        return true;
    }

    public void atualizarEstoque(){
        if(estoqueSuficiente()){
            for(ProdutoVendido prodVend : venda.getProdutosVendidos()){
                prodVend.getProduto().getEstoque().removerQuantidade(prodVend.getQuantidade());
            }
        }
    }

    public static Boolean salvar(Venda venda) {
        return venda != null && venda.getProdutosVendidos() != null && VendaDao.salvar(venda);
    }
}
