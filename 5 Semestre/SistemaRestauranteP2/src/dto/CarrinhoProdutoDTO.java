package dto;

import dao.ProdutoDAO;
import models.Carrinho;
import models.CarrinhoProduto;
import models.Produto;

public class CarrinhoProdutoDTO extends InterfaceDTO {
    private String id;
    private CarrinhoDTO carrinho;
    private ProdutoDTO produto;
    private String quantidade;
    private IngredienteEscolhaDTO ingEscolha;

    public CarrinhoProdutoDTO() {
    }

    public CarrinhoProdutoDTO(String id, CarrinhoDTO carrinho, ProdutoDTO produto, String quantidade, IngredienteEscolhaDTO ingEscolha) {
        this.id = id;
        this.carrinho = carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.ingEscolha = ingEscolha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarrinhoDTO getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDTO carrinho) {
        this.carrinho = carrinho;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public IngredienteEscolhaDTO getIngEscolha() {
        return ingEscolha;
    }

    public void setIngEscolha(IngredienteEscolhaDTO ingEscolha) {
        this.ingEscolha = ingEscolha;
    }

    public CarrinhoProduto builder() {
        CarrinhoProduto carrinhoProduto = new CarrinhoProduto();
        carrinhoProduto.setId(Integer.parseInt(id));
        carrinhoProduto.setCarrinho(carrinho.builder());
        carrinhoProduto.setProduto(produto.builder());
        carrinhoProduto.setQuantidade(Integer.parseInt(quantidade));
        carrinhoProduto.setIngEscolha(ingEscolha.builder());
        return carrinhoProduto;
    }
}
