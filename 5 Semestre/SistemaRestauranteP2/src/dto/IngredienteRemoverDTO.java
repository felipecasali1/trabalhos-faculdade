package dto;

import models.IngredienteRemover;

public class IngredienteRemoverDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    public IngredienteRemoverDTO() {
    }

    public IngredienteRemoverDTO(String id, String nome, IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        this.id = id;
        this.nome = nome;
        this.ingredienteEscolhaDTO = ingredienteEscolhaDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IngredienteEscolhaDTO getIngredienteEscolhaDTO() {
        return ingredienteEscolhaDTO;
    }

    public void setIngredienteEscolhaDTO(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        this.ingredienteEscolhaDTO = ingredienteEscolhaDTO;
    }

    public IngredienteRemover builder() {
        IngredienteRemover ingredienteRemover = new IngredienteRemover();
        ingredienteRemover.setId(Integer.parseInt(id));
        ingredienteRemover.setNome(nome);
        ingredienteRemover.setEscolha(ingredienteEscolhaDTO.builder());
        return ingredienteRemover;
    }
}
