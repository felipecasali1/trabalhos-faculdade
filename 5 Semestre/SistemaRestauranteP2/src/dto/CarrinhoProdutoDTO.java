package dto;

import interfaces.InterfaceDTO;
import dao.ProdutoDAO;
import interfaces.InterfaceEntity;
import models.Carrinho;
import models.CarrinhoProduto;
import models.Produto;

public class CarrinhoProdutoDTO extends InterfaceDTO {
    private String id;
    private CarrinhoDTO carrinhoDTO;
    private ProdutoDTO produtoDTO;
    private String quantidade;
    private IngredienteEscolhaDTO ingEscolha;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((CarrinhoProduto) e);
    }

    public static CarrinhoProdutoDTO toDTO(CarrinhoProduto cp) {
        CarrinhoProdutoDTO cpDTO = new CarrinhoProdutoDTO();
        cpDTO.id = cp.getId() + "";
        cpDTO.carrinhoDTO = CarrinhoDTO.toDTO(cp.getCarrinho());
        cpDTO.produtoDTO = ProdutoDTO.toDTO(cp.getProduto());
        cpDTO.quantidade = cp.getQuantidade() + "";
        cpDTO.ingEscolha = IngredienteEscolhaDTO.toDTO(cp.getIngEscolha());
        return cpDTO;
    }

    @Override
    public CarrinhoProduto buildEntity() {
        CarrinhoProduto cp = new CarrinhoProduto();
        cp.setId(Integer.parseInt(id));
        cp.setCarrinho(carrinhoDTO.buildEntity());
        cp.setProduto(produtoDTO.buildEntity());
        cp.setQuantidade(Integer.parseInt(quantidade));
        cp.setIngEscolha(ingEscolha.buildEntity());
        return cp;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Carrinho", "Produto", "Quantidade", "Mudança de Ingredientes"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, carrinhoDTO.id, produtoDTO.nome, quantidade, ingEscolha.id};
    }
}
