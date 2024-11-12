package main.controller;

import main.models.Categoria;
import main.persistence.CategoriaDao;

public class CategoriaController {
    public static Boolean salvar(Categoria categoria) {
        return categoria != null && CategoriaDao.salvar(categoria);
    }

    public static Boolean excluir(Categoria categoria) {
        return categoria != null && CategoriaDao.excluir(categoria);
    }

    public static Boolean editar(Integer codigo, Categoria categoria) {
        return categoria != null && CategoriaDao.editar(codigo, categoria);
    }

    public static Boolean verificarCodigo(Integer codigo) {
        return codigo != null && CategoriaDao.categoriaExiste(codigo);
    }

    public static String toString(Categoria categoria) {
        if (categoria != null) {
            return "Categoria: " + categoria.getNome() +
                    "\nCódigo: " + categoria.getCodigo();
        }
        return null;
    }
}
