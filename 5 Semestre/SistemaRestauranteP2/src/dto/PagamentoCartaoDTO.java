package dto;

import interfaces.InterfaceDTO;
import models.PagamentoCartao;
import models.TipoPagamentoCartao;

public class PagamentoCartaoDTO extends InterfaceDTO {
    public String tipoPagamentoCartao;

    public static PagamentoCartaoDTO buildDTO(PagamentoCartao pagamentoCartao) {
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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
