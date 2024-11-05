package persistence;

import models.Categoria;
import models.Fornecedor;

import java.util.LinkedList;
import java.util.List;

public class FornecedorDao {
    private static final List<Fornecedor> fornecedores = new LinkedList<>();

    public static List<Fornecedor> getFornecedores () {
        return fornecedores;
    }

    public static void salvar(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public static void excluir(Fornecedor fornecedor) {
        fornecedores.remove(fornecedor);
    }

    public static void editar(String cnpj, Fornecedor fornecedor) {
        Fornecedor forn = buscarFornecedor(cnpj);
        if(forn != null) {
            forn.setNome(fornecedor.getNome());
        }
    }

    public static Fornecedor buscarFornecedor(String cnpj) {
        for(Fornecedor fornecedor : fornecedores){
            if(fornecedor.getCnpj().equals(cnpj)){
                return fornecedor;
            }
        }
        return null;
    }

    public static Boolean fornecedorExiste(String cnpj) {
        return buscarFornecedor(cnpj) != null;
    }

    public static Boolean contains(Fornecedor fornecedor) {
        return fornecedores.contains(fornecedor) && fornecedor != null;
    }

    public static Boolean isEmpty() {
        return fornecedores.isEmpty();
    }
}
