package models;

import interfaces.InterfaceEntity;

import java.util.List;

public class Carrinho extends InterfaceEntity {
    private int id;
    private List<CarrinhoProduto> itens;

    public Carrinho() {
    }

    public Carrinho(int id, List<CarrinhoProduto> itens) {
        this.id = id;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CarrinhoProduto> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoProduto> itens) {
        this.itens = itens;
    }
}
