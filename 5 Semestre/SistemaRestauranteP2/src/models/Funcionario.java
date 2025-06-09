package models;

import interfaces.InterfaceEntity;

import java.util.List;

public class Funcionario extends InterfaceEntity {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private Login login;
    private List<Integer> telefoneIds;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cpf, String rg, Login login, List<Integer> telefones) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.login = login;
        this.telefoneIds = telefones;
    }

    public List<Integer> getTelefoneIds() {
        return telefoneIds;
    }

    public void setTelefoneIds(List<Integer> telefoneIds) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
