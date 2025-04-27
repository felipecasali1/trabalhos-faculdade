package models;

public abstract class MetodoPagamento {
    private int id;
    
    public MetodoPagamento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
