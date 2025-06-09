package models;

import interfaces.InterfaceEntity;

import java.util.List;

public class Carrinho extends InterfaceEntity {
    private int id;
    private List<Integer> carrinhoProdutoIds;

    public Carrinho() {
    }

    public Carrinho(int id, List<Integer> carrinhoProdutoIds) {
        this.id = id;
        this.carrinhoProdutoIds = carrinhoProdutoIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getCarrinhoProdutoIds() {
        return carrinhoProdutoIds;
    }

    public void setCarrinhoProdutoIds(List<Integer> carrinhoProdutoIds) {
        this.carrinhoProdutoIds = carrinhoProdutoIds;
    }
}