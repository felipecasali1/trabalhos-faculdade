package controller;

import models.Categoria;
import persistence.CategoriaDao;

public class CategoriaController {
    private Categoria categoria;

    public CategoriaController(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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
        return CategoriaDao.categoriaExiste(codigo);
    }

    public static String toString(Categoria categoria) {
        if (categoria != null) {
            return "Categoria: " + categoria.getNome() +
                    "\nCódigo: " + categoria.getCodigo();
        }
        return null;
    }
}
