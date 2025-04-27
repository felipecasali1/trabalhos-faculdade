package models;

public class TaxaEntrega {
    private int id;
    private float taxa;

    public TaxaEntrega(int id, float taxa) {
        this.id = id;
        this.taxa = taxa;
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
}
