package models;

public class Pessoa {
    private String nome;
    private String cpf;
    private String cidade;

    public Pessoa() {
        this.nome = "";
        this.cpf = "";
        this.cidade = "";
    }

    public Pessoa(String nome, String cpf, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
