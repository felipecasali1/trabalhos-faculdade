package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.TaxaEntrega;

public class TaxaEntregaDTO extends InterfaceDTO {
    public String taxa;
    public EntregaDTO entregaDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((TaxaEntrega) e);
    }

    public static TaxaEntregaDTO toDTO(TaxaEntrega taxaEntrega) {
        TaxaEntregaDTO teDTO = new TaxaEntregaDTO();
        teDTO.id = taxaEntrega.getId() + "";
        teDTO.taxa = taxaEntrega.getTaxa() + "";
        teDTO.entregaDTO = EntregaDTO.toDTO(taxaEntrega.getEntrega());
        return teDTO;
    }

    @Override
    public TaxaEntrega buildEntity() {
        TaxaEntrega taxaEntrega = new TaxaEntrega();
        taxaEntrega.setId(Integer.parseInt(id));
        taxaEntrega.setTaxa(Float.parseFloat(taxa));
        taxaEntrega.setEntrega(entregaDTO.buildEntity());
        return taxaEntrega;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Taxa Entrega", "Entrega"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, taxa, entregaDTO.tipoEntrega};
    }
}
