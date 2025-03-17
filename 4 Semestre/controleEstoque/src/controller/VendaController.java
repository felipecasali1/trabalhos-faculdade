package main.controller;

import main.models.ProdutoVendido;
import main.models.Venda;
import main.persistence.VendaDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VendaController {

    public static Boolean salvar(Venda venda) {
        return venda != null && venda.getProdutosVendidos() != null && VendaDao.salvar(venda);
    }

    public static String toString(Venda venda) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Cliente: " + venda.getCliente().getNome() +
                "\nCPF: " + venda.getCliente().getCpf() +
                "\nData: " + sdf.format(venda.getData()) +
                "\nVendedor: " + venda.getVendedor().getNome() +
                "\nValor Total: R$" + venda.getValorTotal() +
                "\nQuantidade Total: " + venda.getQuantidadeTotal() +
                "\nProdutos Vendidos: \n" + venda.getProdutosVendidos();
    }

    public static String toStringRelatorio(Venda venda) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Cliente: " + venda.getCliente().getNome() +
                " | CPF: " + venda.getCliente().getCpf() +
                " | Data: " + sdf.format(venda.getData()) +
                " | Vendedor: " + venda.getVendedor().getNome() +
                " | Valor Total: R$" + venda.getValorTotal() +
                " | Quantidade Total: " + venda.getQuantidadeTotal() +
                " | Produtos Vendidos: " + venda.getProdutosVendidos();
    }

    public static Date zerarHoras(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Boolean periodoValido(Date dataInicial, Date dataFinal) {
        return dataInicial.before(dataFinal) || dataInicial.equals(dataFinal);
    }
}
