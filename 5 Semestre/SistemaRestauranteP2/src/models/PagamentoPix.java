package models;

import interfaces.InterfaceEntity;

public class PagamentoPix extends InterfaceEntity {
    private String chavePix;

    public PagamentoPix() {
    }

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
