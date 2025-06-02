package dto;

import interfaces.InterfaceDTO;
import models.TaxaEntrega;

public class TaxaEntregaDTO extends InterfaceDTO {
    public String id;
    public String taxa;
    public EntregaDTO entregaDTO;

    public static TaxaEntregaDTO buildDTO(TaxaEntrega taxaEntrega) {
        TaxaEntregaDTO teDTO = new TaxaEntregaDTO();
        teDTO.id = taxaEntrega.getId() + "";
        teDTO.taxa = taxaEntrega.getTaxa() + "";
        teDTO.entregaDTO = EntregaDTO.buildDTO(taxaEntrega.getEntrega());
        return teDTO;
    }

    public TaxaEntrega buildEntity() {
        TaxaEntrega taxaEntrega = new TaxaEntrega();
        taxaEntrega.setId(Integer.parseInt(id));
        taxaEntrega.setTaxa(Float.parseFloat(taxa));
        taxaEntrega.setEntrega(entregaDTO.buildEntity());
        return taxaEntrega;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
