package models;

public class TaxaEntrega {
    private int id;
    private float taxa;
    private Entrega entrega;

    public TaxaEntrega() {
    }

    public TaxaEntrega(int id, float taxa, Entrega entrega) {
        this.id = id;
        this.taxa = taxa;
        this.entrega = entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}
