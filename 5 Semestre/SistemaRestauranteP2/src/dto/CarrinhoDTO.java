package dto;

import interfaces.InterfaceDTO;
import models.Carrinho;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDTO extends InterfaceDTO {
    public String id;
    public List<CarrinhoProdutoDTO> itens;

    public static CarrinhoDTO buildDTO(Carrinho carrinho) {
        CarrinhoDTO cDTO = new CarrinhoDTO();
        cDTO.id = carrinho.getId() + "";
        cDTO.itens = carrinho.getItens()
                .stream()
                .map(CarrinhoProdutoDTO::buildDTO)
                .collect(Collectors.toList());
        return cDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
