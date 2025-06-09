package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Produto;

public class ProdutoDTO extends InterfaceDTO {
    public String valorUnitario;
    public String nome;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Produto) e);
    }

    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO pDTO = new ProdutoDTO();
        pDTO.id = produto.getId() + "";
        pDTO.valorUnitario = produto.getValorUnitario() + "";
        pDTO.nome = produto.getNome();
        return pDTO;
    }

    @Override
    public Produto buildEntity() {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(id));
        produto.setValorUnitario(Float.parseFloat(valorUnitario));
        produto.setNome(nome);
        return produto;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Valor Unitário", "Nome"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, valorUnitario, nome};
    }
}
