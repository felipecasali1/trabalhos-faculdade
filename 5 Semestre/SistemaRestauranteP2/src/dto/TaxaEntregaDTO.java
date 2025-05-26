package dto;

import models.TaxaEntrega;

public class TaxaEntregaDTO extends InterfaceDTO {
    public String id;
    public String taxa;
    public EntregaDTO entregaDTO;

    public TaxaEntregaDTO() {
    }

    public TaxaEntregaDTO(String id, String taxa, EntregaDTO entregaDTO) {
        this.id = id;
        this.taxa = taxa;
        this.entregaDTO = entregaDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public EntregaDTO getEntregaDTO() {
        return entregaDTO;
    }

    public void setEntregaDTO(EntregaDTO entregaDTO) {
        this.entregaDTO = entregaDTO;
    }

    public TaxaEntrega builder() {
        TaxaEntrega taxaEntrega = new TaxaEntrega();
        taxaEntrega.setId(Integer.parseInt(id));
        taxaEntrega.setTaxa(Float.parseFloat(taxa));
        taxaEntrega.setEntrega(entregaDTO.builder());
        return taxaEntrega;
    }
}
