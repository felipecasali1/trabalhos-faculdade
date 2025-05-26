package dto;

import models.PagamentoPix;

public class PagamentoPixDTO extends InterfaceDTO {
    public String chavePix;

    public PagamentoPixDTO() {
    }

    public PagamentoPixDTO(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public PagamentoPix builder() {
        PagamentoPix pagamentoPix = new PagamentoPix();
        pagamentoPix.setChavePix(chavePix);
        return pagamentoPix;
    }
}
