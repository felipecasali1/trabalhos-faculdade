package models;

public class IngredienteAdicionar {
    private int id;
    private String nome;
    private float valor;
    private IngredienteEscolha ingEscolha;

    public IngredienteAdicionar(int id, String nome, float valor, IngredienteEscolha ingEscolha) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingEscolha = ingEscolha;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public IngredienteEscolha getIngEscolha() {
        return ingEscolha;
    }

    public void setIngEscolha(IngredienteEscolha ingEscolha) {
        this.ingEscolha = ingEscolha;
    }
}
