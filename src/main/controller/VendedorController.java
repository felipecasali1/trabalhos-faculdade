package main.controller;

import main.models.Vendedor;
import main.persistence.ClienteDao;
import main.persistence.VendedorDao;

public class VendedorController {
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

    public static Vendedor buscarVendedor(String cpf) {
        return VendedorDao.buscarVendedor(cpf);
    }

    public static String toString(Vendedor vendedor) {
        if (vendedor != null) {
            return "Nome: " + vendedor.getNome() +
                    "\nCpf: " + vendedor.getCpf();
        }
        return null;
    }
}
