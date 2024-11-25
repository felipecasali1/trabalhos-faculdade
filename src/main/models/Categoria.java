package main.models;

public class Categoria {
    private String nome;
    private Integer codigo;

    public Categoria() {
        this.nome = "";
        this.codigo = null;
    }

    public Categoria(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
