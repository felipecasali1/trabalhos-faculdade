package main.controller;

import main.models.Fornecedor;
import main.persistence.FornecedorDao;

public class FornecedorController {
    public static Boolean salvar(Fornecedor fornecedor) {
        return fornecedor != null && FornecedorDao.salvar(fornecedor);
    }

    public static Boolean excluir(Fornecedor fornecedor) {
        return fornecedor != null && FornecedorDao.excluir(fornecedor);
    }

    public static Boolean editar(String cnpj, Fornecedor fornecedor) {
        return fornecedor != null && FornecedorDao.editar(cnpj, fornecedor);
    }

    public static Boolean verificarCnpj(String cnpj) {
        return FornecedorDao.fornecedorExiste(cnpj);
    }

    public static String toString(Fornecedor fornecedor) {
        if (fornecedor != null) {
            return "Fornecedor: " + fornecedor.getNome() +
                    "\nCnpj: " + fornecedor.getCnpj();
        }
        return null;
    }
}
