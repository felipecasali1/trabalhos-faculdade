package main.models;

public class Produto {
    private String nome;
    private Integer codigo;
    private Float preco;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private Estoque estoque;

    public Produto() {
        this.nome = "";
        this.codigo = 0;
        this.preco = 0.0f;
        this.categoria = new Categoria();
        this.fornecedor = new Fornecedor();
        this.estoque = new Estoque();
    }

    public Produto(String nome, Integer codigo, Float preco, Categoria categoria, Fornecedor fornecedor, Estoque estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return nome;
    }
}