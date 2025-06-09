package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.IngredienteAdicionar;

public class IngredienteAdicionarDTO extends InterfaceDTO {
    public String nome;
    public String valor;
    public IngredienteEscolhaDTO ingredienteEscolhaDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((IngredienteAdicionar) e);
    }

    public static IngredienteAdicionarDTO toDTO(IngredienteAdicionar ingredienteAdicionar) {
        IngredienteAdicionarDTO iaDTO = new IngredienteAdicionarDTO();
        iaDTO.id = ingredienteAdicionar.getId() + "";
        iaDTO.nome = ingredienteAdicionar.getNome();
        iaDTO.valor = ingredienteAdicionar.getValor() + "";
        iaDTO.ingredienteEscolhaDTO = IngredienteEscolhaDTO.toDTO(ingredienteAdicionar.getIngEscolha());
        return  iaDTO;
    }

    @Override
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
        return new String[]{"Id", "Nome", "Valor"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, nome, valor};
    }
}
