package main.persistence;

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
}
