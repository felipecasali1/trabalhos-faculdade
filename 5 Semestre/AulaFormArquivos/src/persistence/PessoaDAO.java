package persistence;

import java.util.LinkedList;
import java.util.List;
import models.Pessoa;

public class PessoaDAO {
    private static List<Pessoa> pessoas = new LinkedList<>();
    
    static {
        if(GerenciadorArquivos.fileExist()) {
           recuperarLista();
        }
    }
    
    public static void salvar(Pessoa pessoa) {
        if(!verificar(pessoa)) {
            pessoas.add(pessoa);
            atualizar();
        }
    }
    
    public static void remover(Pessoa pessoa) {
        if(verificar(pessoa)) {
            pessoas.remove(pessoa);
            atualizar();
        }
    }
    
    public static void atualizar() {
        GerenciadorArquivos.escreverObjetos(pessoas);
    }
    
    public static boolean verificar(Pessoa pessoa) {
        return pessoas.contains(pessoa);
    }
    
    public static void recuperarLista() {
        pessoas = GerenciadorArquivos.lerObjetos();        
    }
}
