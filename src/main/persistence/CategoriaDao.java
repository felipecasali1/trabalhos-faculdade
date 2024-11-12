package main.persistence;

import main.models.Categoria;

import java.util.LinkedList;
import java.util.List;

public class CategoriaDao {
    private static final List<Categoria> categorias = new LinkedList<>();

    public static List<Categoria> getCategorias () {
        return categorias;
    }

    public static Boolean salvar(Categoria categoria) {
        if (CategoriaDao.buscarCategoria(categoria.getCodigo()) == null) {
            categorias.add(categoria);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Categoria categoria) {
        if (categorias.contains(categoria)) {
            categorias.remove(categoria);
            return true;
        }
        return false;
    }

    public static Boolean editar(Integer codigo, Categoria categoria) {
        Categoria cat = buscarCategoria(codigo);
        if (cat != null) {
            categoria.setNome(cat.getNome());
            return true;
        }
        return false;
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
        return categorias.contains(categoria);
    }

    public static Boolean isEmpty() {
        return categorias.isEmpty();
    }
}
