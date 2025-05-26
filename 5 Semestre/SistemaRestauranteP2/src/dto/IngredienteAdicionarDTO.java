package dto;

import models.IngredienteAdicionar;

public class IngredienteAdicionarDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public String valor;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    public IngredienteAdicionarDTO() {
    }

    public IngredienteAdicionarDTO(String id, String nome, String valor, IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public IngredienteEscolhaDTO getIngredienteEscolhaDTO() {
        return ingredienteEscolhaDTO;
    }

    public void setIngredienteEscolhaDTO(IngredienteEscolhaDTO ingredienteEscolhaDTO) {
        this.ingredienteEscolhaDTO = ingredienteEscolhaDTO;
    }

    public IngredienteAdicionar builder() {
        IngredienteAdicionar ingredienteAdicionar = new IngredienteAdicionar();
        ingredienteAdicionar.setId(Integer.parseInt(id));
        ingredienteAdicionar.setNome(nome);
        ingredienteAdicionar.setValor(Float.parseFloat(valor));
        ingredienteAdicionar.setIngEscolha(ingredienteEscolhaDTO.builder());
        return ingredienteAdicionar;
    }
}
