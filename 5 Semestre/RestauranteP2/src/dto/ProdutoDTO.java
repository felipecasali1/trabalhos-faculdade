package dto;

import interfaces.InterfaceDTO;
import models.Produto;

public class ProdutoDTO extends InterfaceDTO {
    public String id;
    public String valorUnitario;
    public String nome;

    public static ProdutoDTO buildDTO(Produto produto) {
        ProdutoDTO pDTO = new ProdutoDTO();
        pDTO.id = produto.getId() + "";
        pDTO.valorUnitario = produto.getValorUnitario() + "";
        pDTO.nome = produto.getNome();
        return pDTO;
    }

    public Produto buildEntity() {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(id));
        produto.setValorUnitario(Float.parseFloat(valorUnitario));
        produto.setNome(nome);
        return produto;
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
