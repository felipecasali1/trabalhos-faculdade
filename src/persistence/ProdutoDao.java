package persistence;

import models.Categoria;
import models.Produto;

import java.util.LinkedList;
import java.util.List;

public class ProdutoDao {
    private static final List<Produto> produtos = new LinkedList<>();

    public static List<Produto> getProdutos () {
        return produtos;
    }

    public static void salvar(Produto produto) {
        produtos.add(produto);
    }

    public static void excluir(Produto produto) {
        produtos.remove(produto);
    }

    public static void editar(Integer codigo, Produto produtoMod) {
        Produto prodE = buscarProduto(codigo);
        if(prodE != null && produtoMod != null) {
            prodE.setNome(produtoMod.getNome());
            prodE.setPreco(produtoMod.getPreco());
            prodE.setCategoria(produtoMod.getCategoria());
            prodE.setEstoque(produtoMod.getEstoque());
            prodE.setFornecedor(produtoMod.getFornecedor());
        }
    }

    public static Produto buscarProduto(Integer codigo) {
        for(Produto prod : produtos){
            if(prod.getCodigo().equals(codigo)){
                return prod;
            }
        }
        return null;
    }

    public static Boolean produtoExiste (Integer codigo) {
        return buscarProduto(codigo) != null;
    }

    public static Boolean contains(Produto produto) {
        return produtos.contains(produto) && produto != null;
    }

    public static Boolean isEmpty() {
        return produtos.isEmpty();
    }
}
