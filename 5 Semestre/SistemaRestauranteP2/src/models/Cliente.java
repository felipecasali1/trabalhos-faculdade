package models;

import interfaces.InterfaceEntity;

import java.util.List;

public class Cliente extends InterfaceEntity {
    private int id;
    private String nome;
    private List<Telefone> telefones;

    public Cliente() {
    }

    public Cliente(int id, String nome, List<Telefone> telefones) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    
}
