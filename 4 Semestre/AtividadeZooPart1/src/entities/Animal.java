package entities;

public class Animal {
    private String nome;
    private String especie;
    private String cor;
    private String habitat;
    private Integer idade;
    private Float peso;

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getCor() {
        return cor;
    }

    public String getHabitat() {
        return habitat;
    }

    public Integer getIdade() {
        return idade;
    }

    public Float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
}
