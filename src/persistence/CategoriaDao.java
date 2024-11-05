package persistence;

import models.Categoria;

import java.util.LinkedList;
import java.util.List;

public class CategoriaDao {
    private static final List<Categoria> categorias = new LinkedList<>();

    public static List<Categoria> getCategorias () {
        return categorias;
    }

    public static void salvar(Categoria categoria) {
        categorias.add(categoria);
    }

    public static void excluir(Categoria categoria) {
        categorias.remove(categoria);
    }

    public static void editar(Integer codigo, Categoria categoria) {
        Categoria cat = buscarCategoria(codigo);
        cat.setNome(categoria.getNome());
    }

    public static Categoria buscarCategoria(Integer codigo) {
        for(Categoria cat : categorias){
            if(cat.getCodigo().equals(codigo)){
                return cat;
            }
        }
        return null;
    }

    public static Boolean categoriaExiste(Integer codigo) {
        return buscarCategoria(codigo) != null;
    }

    public static Boolean contains(Categoria categoria) {
        return categorias.contains(categoria) && categoria != null;
    }

    public static Boolean isEmpty() {
        return categorias.isEmpty();
    }
}
