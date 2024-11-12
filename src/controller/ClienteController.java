package controller;

import models.Cliente;
import persistence.ClienteDao;

public class ClienteController {
    private Cliente cliente;

    public ClienteController(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static Boolean salvar(Cliente cliente) {
        return cliente != null && ClienteDao.salvar(cliente);
    }

    public static Boolean excluir(Cliente cliente) {
        return cliente != null && ClienteDao.excluir(cliente);
    }

    public static Boolean editar(String cpf, Cliente cliente) {
        return cliente != null && ClienteDao.editar(cpf, cliente);
    }
}
