package controller;

import models.Categoria;
import persistence.CategoriaDao;
import persistence.ProdutoDao;

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
        if(categoria != null && ProdutoDao.buscarProduto(categoria.getCodigo()) == null) {
            CategoriaDao.salvar(categoria);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Categoria categoria) {
        if(categoria != null && CategoriaDao.contains(categoria)){
            CategoriaDao.excluir(categoria);
            return true;
        }
        return false;
    }

    public static Boolean editar(Integer codigo, Categoria categoria) {
        if (categoria != null) {
            Categoria cat = CategoriaDao.buscarCategoria(codigo);
            if (cat != null) {
                CategoriaDao.editar(codigo, categoria);
                return true;
            }
        }
        return false;
    }
}
