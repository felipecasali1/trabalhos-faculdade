package main.persistence;

import main.controller.VendaController;
import main.models.Categoria;
import main.models.Produto;
import main.models.ProdutoVendido;
import main.models.Venda;

import java.util.Date;
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

    public static List<Venda> vendasPorProduto(Produto prod) {
        List<Venda> vendasProd = new LinkedList<>();
        for(Venda v : vendas) {
            for (ProdutoVendido prodV : v.getProdutosVendidos()) {
                if(prodV.getProduto().equals(prod)) {
                    vendasProd.add(v);
                }
            }
        }
        if(!vendasProd.isEmpty()) {
            return vendasProd;
        }
        return null;
    }

    public static List<Venda> vendasPorCategoria(Categoria cat) {
        List<Venda> vendasCat = new LinkedList<>();
        for(Venda v : vendas) {
            for (ProdutoVendido prodV : v.getProdutosVendidos()) {
                if (prodV.getProduto().getCategoria().equals(cat)) {
                    if (!vendasCat.contains(v)) {
                        vendasCat.add(v);
                    }
                    break;
                }
            }
        }
        if(!vendasCat.isEmpty()) {
            return vendasCat;
        }
        return null;
    }

    public static List<Venda> vendasPorPeriodo(Date dataInicial, Date dataFinal) {
        List<Venda> vendasPeriodo = new LinkedList<>();
        if (VendaController.periodoValido(dataInicial, dataFinal)) {
            for (Venda v : vendas) {
                if (v.getData().after(dataInicial) && v.getData().before(dataFinal)) {
                    vendasPeriodo.add(v);
                }
            }
            return vendasPeriodo;
        }
        return null;
    }

    public static Boolean isEmpty() {
        return vendas.isEmpty();
    }
}
