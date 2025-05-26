package dto;

import models.PagamentoCartao;
import models.TipoPagamentoCartao;

public class PagamentoCartaoDTO extends InterfaceDTO {
    public String tipoPagamentoCartao;

    public PagamentoCartaoDTO() {
    }

    public PagamentoCartaoDTO(String tipoPagamentoCartao) {
        this.tipoPagamentoCartao = tipoPagamentoCartao;
    }

    public String getTipoPagamentoCartao() {
        return tipoPagamentoCartao;
    }

    public void setTipoPagamentoCartao(String tipoPagamentoCartao) {
        this.tipoPagamentoCartao = tipoPagamentoCartao;
    }

    public PagamentoCartao builder() {
        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setTipo(TipoPagamentoCartao.valueOf(tipoPagamentoCartao));
        return pagamentoCartao;
    }
}
