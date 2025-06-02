package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Carrinho;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDTO extends InterfaceDTO {
    public String id;
    public List<CarrinhoProdutoDTO> itens;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Carrinho) e);
    }

    public static CarrinhoDTO toDTO(Carrinho carrinho) {
        CarrinhoDTO cDTO = new CarrinhoDTO();
        cDTO.id = carrinho.getId() + "";
        cDTO.itens = carrinho.getItens()
                .stream()
                .map(CarrinhoProdutoDTO::toDTO)
                .collect(Collectors.toList());
        return cDTO;
    }

    @Override
    public Carrinho buildEntity() {
        Carrinho c = new Carrinho();
        c.setId(Integer.parseInt(id));
        c.setItens(itens
                .stream()
                .map(CarrinhoProdutoDTO::buildEntity)
                .collect(Collectors.toList())
        );
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
}
