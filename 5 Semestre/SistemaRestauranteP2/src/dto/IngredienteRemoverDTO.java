package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.IngredienteRemover;

public class IngredienteRemoverDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((IngredienteRemover) e);
    }

    public static IngredienteRemoverDTO toDTO(IngredienteRemover ingredienteRemover) {
        IngredienteRemoverDTO irDTO = new IngredienteRemoverDTO();
        irDTO.id = ingredienteRemover.getId() + "";
        irDTO.nome = ingredienteRemover.getNome();
        irDTO.ingredienteEscolhaDTO = IngredienteEscolhaDTO.toDTO(ingredienteRemover.getEscolha());
        return irDTO;
    }

    @Override
    public IngredienteRemover buildEntity() {
        IngredienteRemover ingredienteRemover = new IngredienteRemover();
        ingredienteRemover.setId(Integer.parseInt(id));
        ingredienteRemover.setNome(nome);
        ingredienteRemover.setEscolha(ingredienteEscolhaDTO.buildEntity());
        return ingredienteRemover;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Nome"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, nome};
    }
}
