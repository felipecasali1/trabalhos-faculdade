package models;

import interfaces.InterfaceEntity;

import java.util.List;

public class Cliente extends InterfaceEntity {
    private int id;
    private String nome;
    private List<Integer> telefoneIds;

    public Cliente() {
    }

    public Cliente(int id, String nome, List<Integer> telefoneIds) {
        this.id = id;
        this.nome = nome;
        this.telefoneIds = telefoneIds;
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

    public List<Integer> getTelefoneIds() {
        return telefoneIds;
    }

    public void setTelefoneIds(List<Integer> telefoneIds) {
        this.telefoneIds = telefoneIds;
    }
}
