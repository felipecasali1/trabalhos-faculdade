package persistence;

import models.Produto;

import java.util.LinkedList;
import java.util.List;

public class ProdutoDao {
    private static final List<Produto> produtos = new LinkedList<>();

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static Boolean salvar(Produto produto) {
        if (ProdutoDao.buscarProduto(produto.getCodigo()) == null) {
            produtos.add(produto);
            return true;
        }
        return false;
    }

    public static Boolean excluir(Produto produto) {
        if (produtos.contains(produto)) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    public static Boolean editar(Integer codigo, Produto produto) {
        Produto prodE = buscarProduto(codigo);
        if (prodE != null) {
            prodE.setNome(produto.getNome());
            prodE.setPreco(produto.getPreco());
            prodE.setCategoria(produto.getCategoria());
            prodE.setEstoque(produto.getEstoque());
            prodE.setFornecedor(produto.getFornecedor());
            return true;
        }
        return false;
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
        return produtos.contains(produto);
    }

    public static Boolean isEmpty() {
        return produtos.isEmpty();
    }
}
