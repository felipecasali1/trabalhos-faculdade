package dto;

import interfaces.InterfaceDTO;
import dao.ProdutoDAO;
import models.Carrinho;
import models.CarrinhoProduto;
import models.Produto;

public class CarrinhoProdutoDTO extends InterfaceDTO {
    private String id;
    private CarrinhoDTO carrinhoDTO;
    private ProdutoDTO produtoDTO;
    private String quantidade;
    private IngredienteEscolhaDTO ingEscolha;

    public static CarrinhoProdutoDTO buildDTO(CarrinhoProduto cp) {
        CarrinhoProdutoDTO cpDTO = new CarrinhoProdutoDTO();
        cpDTO.id = cp.getId() + "";
        cpDTO.carrinhoDTO = CarrinhoDTO.buildDTO(cp.getCarrinho());
        cpDTO.produtoDTO = ProdutoDTO.buildDTO(cp.getProduto());
        cpDTO.quantidade = cp.getQuantidade() + "";
        cpDTO.ingEscolha = IngredienteEscolhaDTO.buildDTO(cp.getIngEscolha());
        return cpDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
