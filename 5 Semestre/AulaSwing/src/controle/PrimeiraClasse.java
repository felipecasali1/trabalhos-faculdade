package controle;
import java.util.LinkedList;
import java.util.List;
class Pessoa{
    public String nome,idade,endereco;
    public Pessoa(String nome, String idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
}
public class PrimeiraClasse {
 private static  List <Pessoa>lista = new LinkedList();
 public static void cadastro(String nome,String idade, String endereco){
     lista.add(new Pessoa(nome, idade, endereco));
 }   
 
 public static int qtdRegistro(){
    return lista.size();
 } 
 public static String[]titulos(){
     return new String[]{"Nome","Idade"};
 }

    public static Object[] getDados(int i) {
        return new Object[]{lista.get(i).nome,lista.get(i).idade};

    }
}
