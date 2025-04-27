package models;

public class Endereco {
    private int id;
    private String rua;
    private String cep;
    private Bairro bairro;
    private float distancia;

    public Endereco(int id, String rua, String cep, Bairro bairro, float distancia) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.distancia = distancia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
}
