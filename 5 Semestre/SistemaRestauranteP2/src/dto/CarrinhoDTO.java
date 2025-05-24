package dto;

import models.Carrinho;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDTO extends InterfaceDTO {
    public String id;
    public List<CarrinhoProdutoDTO> itens;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(String id, List<CarrinhoProdutoDTO> itens) {
        this.id = id;
        this.itens = itens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarrinhoProdutoDTO> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoProdutoDTO> itens) {
        this.itens = itens;
    }

    public Carrinho builder() {
        Carrinho carrinho = new Carrinho();
        carrinho.setId(Integer.parseInt(id));
        carrinho.setItens(itens
                .stream()
                .map(CarrinhoProdutoDTO::builder)
                .collect(Collectors.toList())
        );
        return carrinho;
    }
}
