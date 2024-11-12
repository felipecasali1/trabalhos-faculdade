package main.controller;

import main.models.Cliente;
import main.persistence.ClienteDao;

public class ClienteController {
    public static Boolean salvar(Cliente cliente) {
        return cliente != null && ClienteDao.salvar(cliente);
    }

    public static Boolean excluir(Cliente cliente) {
        return cliente != null && ClienteDao.excluir(cliente);
    }

    public static Boolean editar(String cpf, Cliente cliente) {
        return cliente != null && ClienteDao.editar(cpf, cliente);
    }

    public static Boolean verificarCpf(String cpf) {
        return cpf != null && ClienteDao.clienteExiste(cpf);
    }

    public static String toString(Cliente cliente) {
        if (cliente != null) {
            return "Nome: " + cliente.getNome() +
                    "\nCpf: " + cliente.getCpf() +
                    "\nTelefone: " + cliente.getTelefone() +
                    "\nEmail: " + cliente.getEmail();
        }
        return null;
    }
}
