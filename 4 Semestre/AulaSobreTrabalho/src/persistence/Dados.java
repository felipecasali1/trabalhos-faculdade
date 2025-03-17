package persistence;

import java.util.LinkedList;
import java.util.List;

public class Dados {
    private static List dados = new LinkedList();
    public static void salvar(Object o){
        dados.add(o);
    }
    public static List getDados(Class c){
        List temp = new LinkedList();
        for (Object dado : dados) {
            if(dado.getClass().equals(c)){
                temp.add(dado);
            }
        }
        return temp;
    }
    public static List getDados(){
        
        return dados;
    }
}

