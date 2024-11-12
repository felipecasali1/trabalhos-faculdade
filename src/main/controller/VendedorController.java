package main.controller;

import main.models.Vendedor;
import main.persistence.VendedorDao;

public class VendedorController {
    private Vendedor vendedor;

    public VendedorController(Vendedor vendedor){
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public static Boolean salvar(Vendedor vendedor) {
        return vendedor != null && VendedorDao.salvar(vendedor);
    }

    public static Boolean excluir(Vendedor vendedor) {
        return vendedor != null && VendedorDao.excluir(vendedor);
    }

    public static Boolean editar(String cpf, Vendedor vendedor) {
        return vendedor != null && VendedorDao.editar(cpf, vendedor);
    }

    public static Boolean verificarCpf(String cpf) {
        return VendedorDao.vendedorExiste(cpf);
    }
}
