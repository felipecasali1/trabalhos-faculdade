package models;

public class PagamentoPix extends MetodoPagamento {
    private String chavePix;

    public PagamentoPix(String chavePix, int id) {
        super(id);
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
