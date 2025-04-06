package br.unigran.model;

public class Veiculo {
    private Integer id;
    private String nome;
    private String marca;
    private String cor;
    private Integer km;
    private Float valor;

    public Veiculo(String nome, String marca, String cor, Integer km, Float valor) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.km = km;
        this.valor = valor;
    }
    
    public Veiculo(Integer id, String nome, String marca, String cor, Integer km, Float valor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.km = km;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }    
}