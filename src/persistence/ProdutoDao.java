package persistence;

import models.Produto;

import java.util.LinkedList;
import java.util.List;

public class ProdutoDao {
    private static List<Produto> dados = new LinkedList<>();

    public static void salvar(Produto produto) {
        if(buscarProduto(produto.getCodigo()) == null) {
            dados.add(produto);
        }
    }

    public static void excluir(Produto produto) {
        dados.remove(produto);
    }

    public static void editar(Produto produto) {

    }

    public static Produto buscarProduto(Integer codigo) {
        for(Produto prod : dados){
            if(prod.getCodigo().equals(codigo)){
                return prod;
            }
        }
        return null;
    }
}
