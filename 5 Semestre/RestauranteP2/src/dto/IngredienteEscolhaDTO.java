package dto;

import interfaces.InterfaceDTO;
import models.IngredienteEscolha;

import java.util.List;
import java.util.stream.Collectors;

public class IngredienteEscolhaDTO extends InterfaceDTO {
    public String id;
    public List<IngredienteAdicionarDTO> ingAdicionados;
    public List<IngredienteRemoverDTO> ingRemovidos;

    public static IngredienteEscolhaDTO buildDTO(IngredienteEscolha ingredienteEscolha) {
        IngredienteEscolhaDTO ieDTO = new IngredienteEscolhaDTO();
        ieDTO.id = ingredienteEscolha.getId() + "";
        ieDTO.ingAdicionados = ingredienteEscolha.getIngAdd()
                .stream()
                .map(IngredienteAdicionarDTO::buildDTO)
                .collect(Collectors.toList());
        ieDTO.ingRemovidos = ingredienteEscolha.getIngRemover()
                .stream()
                .map(IngredienteRemoverDTO::buildDTO)
                .collect(Collectors.toList());
        return ieDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
