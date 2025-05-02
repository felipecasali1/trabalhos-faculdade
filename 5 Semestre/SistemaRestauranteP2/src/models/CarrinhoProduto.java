package models;

public class CarrinhoProduto {
    private int id;
    private Carrinho carrinho;
    private Produto produto;
    private int quantidade;
    private IngredienteEscolha ingEscolha;

    public CarrinhoProduto(int id, Carrinho carrinho, Produto produto, int quantidade, IngredienteEscolha ingEscolha) {
        this.id = id;
        this.carrinho = carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.ingEscolha = ingEscolha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public IngredienteEscolha getIngEscolha() {
        return ingEscolha;
    }

    public void setIngEscolha(IngredienteEscolha ingEscolha) {
        this.ingEscolha = ingEscolha;
    }
}

