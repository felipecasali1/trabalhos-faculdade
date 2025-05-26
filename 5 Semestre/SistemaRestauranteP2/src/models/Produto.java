package models;

public class Produto {
    private int id;
    private float valorUnitario;
    private String nome;

    public Produto() {
    }

    public Produto(int id, float valorUnitario, String nome) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
