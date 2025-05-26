package dto;

import models.Pagamento;
import models.TipoPagamento;

public class PagamentoDTO extends InterfaceDTO {
    public String id;
    public PedidoDTO pedidoDTO;
    public CupomDTO cupomDTO;
    public String tipoPagamento;
    public PagamentoPixDTO pagamentoPixDTO;
    public PagamentoCartaoDTO pagamentoCartaoDTO;
    public PagamentoDinheiroDTO pagamentoDinheiroDTO;

    public PagamentoDTO() {
    }

    public PagamentoDTO(String id, PedidoDTO pedidoDTO, CupomDTO cupomDTO, String tipoPagamento, PagamentoPixDTO pagamentoPixDTO, PagamentoCartaoDTO pagamentoCartaoDTO, PagamentoDinheiroDTO pagamentoDinheiroDTO) {
        this.id = id;
        this.pedidoDTO = pedidoDTO;
        this.cupomDTO = cupomDTO;
        this.tipoPagamento = tipoPagamento;
        this.pagamentoPixDTO = pagamentoPixDTO;
        this.pagamentoCartaoDTO = pagamentoCartaoDTO;
        this.pagamentoDinheiroDTO = pagamentoDinheiroDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PedidoDTO getPedidoDTO() {
        return pedidoDTO;
    }

    public void setPedidoDTO(PedidoDTO pedidoDTO) {
        this.pedidoDTO = pedidoDTO;
    }

    public CupomDTO getCupomDTO() {
        return cupomDTO;
    }

    public void setCupomDTO(CupomDTO cupomDTO) {
        this.cupomDTO = cupomDTO;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public PagamentoPixDTO getPagamentoPixDTO() {
        return pagamentoPixDTO;
    }

    public void setPagamentoPixDTO(PagamentoPixDTO pagamentoPixDTO) {
        this.pagamentoPixDTO = pagamentoPixDTO;
    }

    public PagamentoCartaoDTO getPagamentoCartaoDTO() {
        return pagamentoCartaoDTO;
    }

    public void setPagamentoCartaoDTO(PagamentoCartaoDTO pagamentoCartaoDTO) {
        this.pagamentoCartaoDTO = pagamentoCartaoDTO;
    }

    public PagamentoDinheiroDTO getPagamentoDinheiroDTO() {
        return pagamentoDinheiroDTO;
    }

    public void setPagamentoDinheiroDTO(PagamentoDinheiroDTO pagamentoDinheiroDTO) {
        this.pagamentoDinheiroDTO = pagamentoDinheiroDTO;
    }

    public Pagamento builder() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(Integer.parseInt(id));
        pagamento.setPedido(pedidoDTO.builder());
        pagamento.setCupom(cupomDTO.builder());
        pagamento.setTipo(TipoPagamento.valueOf(tipoPagamento));
        pagamento.setPagamentoPix(pagamentoPixDTO.builder());
        pagamento.setPagamentoCartao(pagamentoCartaoDTO.builder());
        pagamento.setPagamentoDinheiro(pagamentoDinheiroDTO.builder());
        return pagamento;
    }
}
