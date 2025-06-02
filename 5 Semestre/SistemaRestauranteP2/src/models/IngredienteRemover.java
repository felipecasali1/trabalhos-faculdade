package models;

import interfaces.InterfaceEntity;

public class IngredienteRemover extends InterfaceEntity {
    private int id;
    private String nome;
    private IngredienteEscolha escolha;

    public IngredienteRemover() {
    }

    public IngredienteRemover(int id, String nome, IngredienteEscolha escolha) {
        this.id = id;
        this.nome = nome;
        this.escolha = escolha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IngredienteEscolha getEscolha() {
        return escolha;
    }

    public void setEscolha(IngredienteEscolha escolha) {
        this.escolha = escolha;
    }
}
