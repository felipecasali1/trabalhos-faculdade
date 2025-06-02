package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.PagamentoCartao;
import models.TipoPagamentoCartao;

public class PagamentoCartaoDTO extends InterfaceDTO {
    public String tipoPagamentoCartao;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((PagamentoCartao) e);
    }

    public static PagamentoCartaoDTO toDTO(PagamentoCartao pagamentoCartao) {
        PagamentoCartaoDTO pcDTO = new PagamentoCartaoDTO();
        pcDTO.tipoPagamentoCartao = pagamentoCartao.getTipo().toString();
        return pcDTO;
    }

    public PagamentoCartao buildEntity() {
        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setTipo(TipoPagamentoCartao.valueOf(tipoPagamentoCartao));
        return pagamentoCartao;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Tipo Pagamento Cartão"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{tipoPagamentoCartao};
    }
}
