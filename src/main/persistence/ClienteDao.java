package main.persistence;

import main.models.Cliente;

import java.util.LinkedList;
import java.util.List;

public class ClienteDao {
    private static final List<Cliente> clientes = new LinkedList<>();

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static Boolean salvar(Cliente cliente) {
        if (VendedorDao.buscarVendedor(cliente.getCpf()) == null) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public static Boolean editar(String cpf, Cliente cliente) {
        Cliente vend = buscarClientes(cpf);
        if(vend != null) {
            vend.setNome(cliente.getNome());
            return true;
        }
        return false;
    }

    public static Cliente buscarClientes(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static Boolean clienteExiste(String cpf) {
        return buscarClientes(cpf) != null;
    }

    public static Boolean contains(Cliente cliente) {
        return clientes.contains(cliente);
    }

    public static Boolean isEmpty() {
        return clientes.isEmpty();
    }
}
