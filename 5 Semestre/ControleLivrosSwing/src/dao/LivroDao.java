package dao;

import java.util.LinkedList;
import java.util.List;
import models.Livro;

public class LivroDao {
    private static List<Livro> livros = new LinkedList<>();
    
    public static void cadastrar(String titulo, String autor, String ano) {
        livros.add(new Livro(titulo, autor, ano));
    }
    
    public static void remover(List<Livro> livrosSelec) {
        livros.removeAll(livrosSelec);
    }
    
    public static void editar(Livro livro, String titulo, String autor, String ano) {
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPub(ano);
    }
    
    public static Object[] getDados(int i) {
        return new Object[]{livros.get(i).getTitulo(),livros.get(i).getAutor(),livros.get(i).getAnoPub()};
    }
    
    public static int qntLivros() {
        return livros.size();
    }
    
    public static List<Livro> getLivros() {
        return livros;
    }    
    
    public static boolean isEmpty() {
        return livros.isEmpty();
    }
}
