package models;

public class Delivery {
    private int id;
    private String numero;
    private String complemento;
    private Endereco endereco;

    public Delivery(int id, String numero, String complemento, Endereco endereco) {
        this.id = id;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
