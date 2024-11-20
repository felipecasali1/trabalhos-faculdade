package main.persistence;

import main.models.Produto;
import main.models.ProdutoVendido;
import main.models.Venda;

import java.util.LinkedList;
import java.util.List;

public class VendaDao {
    public static final List<Venda> vendas = new LinkedList<>();

    public static List<Venda> getVendas() {
        return vendas;
    }

    public static Boolean salvar(Venda venda) {
        if (!venda.getProdutosVendidos().isEmpty()) {
            vendas.add(venda);
            return true;
        }
        return false;
    }

    public static Float calcularValorTotal(Venda venda) {
        Float total = 0.0F;
        for(ProdutoVendido prodV : venda.getProdutosVendidos()) {
            total += prodV.getQuantidade() * prodV.getProduto().getPreco();
        }
        return total;
    }

    public static Integer calcularQuantidadeTotal(Venda venda) {
        Integer quant = 0;
        for(ProdutoVendido prodVend : venda.getProdutosVendidos()) {
            quant += prodVend.getQuantidade();
        }
        return quant;
    }



    public static Boolean isEmpty() {
        return vendas.isEmpty();
    }
}
