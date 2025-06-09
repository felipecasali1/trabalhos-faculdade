package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.IngredienteEscolha;

import java.util.List;
import java.util.stream.Collectors;

public class IngredienteEscolhaDTO extends InterfaceDTO {
    public List<IngredienteAdicionarDTO> ingAdicionados;
    public List<IngredienteRemoverDTO> ingRemovidos;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((IngredienteEscolha) e);
    }

    public static IngredienteEscolhaDTO toDTO(IngredienteEscolha ingredienteEscolha) {
        IngredienteEscolhaDTO ieDTO = new IngredienteEscolhaDTO();
        ieDTO.id = ingredienteEscolha.getId() + "";
        ieDTO.ingAdicionados = ingredienteEscolha.getIngAdd()
                .stream()
                .map(IngredienteAdicionarDTO::toDTO)
                .collect(Collectors.toList());
        ieDTO.ingRemovidos = ingredienteEscolha.getIngRemover()
                .stream()
                .map(IngredienteRemoverDTO::toDTO)
                .collect(Collectors.toList());
        return ieDTO;
    }

    @Override
    public IngredienteEscolha buildEntity() {
        IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
        ingredienteEscolha.setId(Integer.parseInt(id));
        ingredienteEscolha.setIngAdd(ingAdicionados
            .stream()
            .map(IngredienteAdicionarDTO::buildEntity)
            .collect(Collectors.toList())
        );
        ingredienteEscolha.setIngRemover(ingRemovidos
            .stream()
            .map(IngredienteRemoverDTO::buildEntity)
            .collect(Collectors.toList())
        );
        return ingredienteEscolha;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id};
    }
}
