package main.persistence;

import main.models.Vendedor;

import java.util.LinkedList;
import java.util.List;

public class VendedorDao {
    private static final List<Vendedor> vendedores = new LinkedList<>();

    public static List<Vendedor> getVendedores() {
        return vendedores;
    }

    public static Boolean salvar(Vendedor vendedor) {
        if (VendedorDao.buscarVendedor(vendedor.getCpf()) == null) {
            vendedores.add(vendedor);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Vendedor vendedor) {
        if (vendedores.contains(vendedor)) {
            vendedores.remove(vendedor);
            return true;
        }
        return false;
    }

    public static Boolean editar(String cpf, Vendedor vendedor) {
        Vendedor vend = buscarVendedor(cpf);
        if(vend != null) {
            vend.setNome(vendedor.getNome());
            return true;
        }
        return false;
    }

    public static Vendedor buscarVendedor(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        return null;
    }

    public static Boolean vendedorExiste(String cpf) {
        return buscarVendedor(cpf) != null;
    }

    public static Boolean contains(Vendedor vendedor) {
        return vendedores.contains(vendedor);
    }

    public static Boolean isEmpty() {
        return vendedores.isEmpty();
    }
}
