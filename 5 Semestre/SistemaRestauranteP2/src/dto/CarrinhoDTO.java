package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Carrinho;

import java.util.List;

public class CarrinhoDTO extends InterfaceDTO {
    public List<Integer> carrinhoProdutoIds;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Carrinho) e);
    }

    public static CarrinhoDTO toDTO(Carrinho carrinho) {
        CarrinhoDTO cDTO = new CarrinhoDTO();
        cDTO.id = carrinho.getId() + "";
        cDTO.carrinhoProdutoIds = carrinho.getCarrinhoProdutoIds();
        return cDTO;
    }

    @Override
    public Carrinho buildEntity() {
        Carrinho c = new Carrinho();
        c.setId(Integer.parseInt(id));
        c.setCarrinhoProdutoIds(carrinhoProdutoIds);
        return c;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id};
    }

    @Override
    public String toString() {
        return id;
    }
}
