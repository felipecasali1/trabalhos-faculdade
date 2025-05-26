package dto;

import models.Produto;

public class ProdutoDTO extends InterfaceDTO {
    public String id;
    public String valorUnitario;
    public String nome;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String id, String valorUnitario, String nome) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto builder() {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(id));
        produto.setValorUnitario(Float.parseFloat(valorUnitario));
        produto.setNome(nome);
        return produto;
    }
}
