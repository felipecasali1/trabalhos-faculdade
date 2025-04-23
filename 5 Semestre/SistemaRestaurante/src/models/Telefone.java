package models;

public class Telefone {
    private int id;
    private String numero;
    private String ddd;

    public Telefone(int id, String numero, String ddd) {
        this.id = id;
        this.numero = numero;
        this.ddd = ddd;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    
    
}
