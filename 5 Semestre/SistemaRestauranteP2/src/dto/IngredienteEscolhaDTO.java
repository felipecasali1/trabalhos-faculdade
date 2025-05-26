package dto;

import models.IngredienteEscolha;

import java.util.List;
import java.util.stream.Collectors;

public class IngredienteEscolhaDTO extends InterfaceDTO {
    public String id;
    public List<IngredienteAdicionarDTO> ingAdicionados;
    public List<IngredienteRemoverDTO> ingRemovidos;

    public IngredienteEscolhaDTO() {
    }

    public IngredienteEscolhaDTO(String id, List<IngredienteAdicionarDTO> ingAdicionados, List<IngredienteRemoverDTO> ingRemovidos) {
        this.id = id;
        this.ingAdicionados = ingAdicionados;
        this.ingRemovidos = ingRemovidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<IngredienteAdicionarDTO> getIngAdicionados() {
        return ingAdicionados;
    }

    public void setIngAdicionados(List<IngredienteAdicionarDTO> ingAdicionados) {
        this.ingAdicionados = ingAdicionados;
    }

    public List<IngredienteRemoverDTO> getIngRemovidos() {
        return ingRemovidos;
    }

    public void setIngRemovidos(List<IngredienteRemoverDTO> ingRemovidos) {
        this.ingRemovidos = ingRemovidos;
    }

    public IngredienteEscolha builder() {
        IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
        ingredienteEscolha.setId(Integer.parseInt(id));
        ingredienteEscolha.setIngAdd(ingAdicionados
            .stream()
            .map(IngredienteAdicionarDTO::builder)
            .collect(Collectors.toList())
        );
        ingredienteEscolha.setIngRemover(ingRemovidos
            .stream()
            .map(IngredienteRemoverDTO::builder)
            .collect(Collectors.toList())
        );
        return ingredienteEscolha;
    }
}
