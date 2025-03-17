package persistence;

import java.util.LinkedList;
import java.util.List;
import models.Pessoa;

public class PessoaDAO {
    private static final List<Pessoa> pessoas = new LinkedList<>();
    
    public static void salvar(Pessoa pessoa) {
        pessoas.add(pessoa);
        GerenciadorArquivos.escreverObjetos(pessoas);
    }
    
    public static void remover(Pessoa pessoa) {
        pessoas.remove(pessoa);
        GerenciadorArquivos.escreverObjetos(pessoas);
    }
}
