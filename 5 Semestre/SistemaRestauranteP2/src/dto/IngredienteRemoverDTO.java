package dto;

import interfaces.InterfaceDTO;
import models.IngredienteRemover;

public class IngredienteRemoverDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    public static IngredienteRemoverDTO buildDTO(IngredienteRemover ingredienteRemover) {
        IngredienteRemoverDTO irDTO = new IngredienteRemoverDTO();
        irDTO.id = ingredienteRemover.getId() + "";
        irDTO.nome = ingredienteRemover.getNome();
        irDTO.ingredienteEscolhaDTO = IngredienteEscolhaDTO.buildDTO(ingredienteRemover.getEscolha());
        return irDTO;
    }

    public IngredienteRemover buildEntity() {
        IngredienteRemover ingredienteRemover = new IngredienteRemover();
        ingredienteRemover.setId(Integer.parseInt(id));
        ingredienteRemover.setNome(nome);
        ingredienteRemover.setEscolha(ingredienteEscolhaDTO.buildEntity());
        return ingredienteRemover;
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
