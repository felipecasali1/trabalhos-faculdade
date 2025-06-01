package dto;

import interfaces.InterfaceDTO;
import models.IngredienteAdicionar;

public class IngredienteAdicionarDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public String valor;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    public static IngredienteAdicionarDTO buildDTO(IngredienteAdicionar ingredienteAdicionar) {
        IngredienteAdicionarDTO iaDTO = new IngredienteAdicionarDTO();
        iaDTO.id = ingredienteAdicionar.getId() + "";
        iaDTO.nome = ingredienteAdicionar.getNome();
        iaDTO.valor = ingredienteAdicionar.getValor() + "";
        iaDTO.ingredienteEscolhaDTO = IngredienteEscolhaDTO.buildDTO(ingredienteAdicionar.getIngEscolha());
        return  iaDTO;
    }

    public IngredienteAdicionar buildEntity() {
        IngredienteAdicionar ingredienteAdicionar = new IngredienteAdicionar();
        ingredienteAdicionar.setId(Integer.parseInt(id));
        ingredienteAdicionar.setNome(nome);
        ingredienteAdicionar.setValor(Float.parseFloat(valor));
        ingredienteAdicionar.setIngEscolha(ingredienteEscolhaDTO.buildEntity());
        return ingredienteAdicionar;
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
