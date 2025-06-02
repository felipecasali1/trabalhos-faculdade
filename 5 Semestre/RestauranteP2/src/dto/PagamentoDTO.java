package dto;

import interfaces.InterfaceDTO;
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

    public static PagamentoDTO buildDTO(Pagamento pagamento) {
        PagamentoDTO pDTO = new PagamentoDTO();
        pDTO.id = pagamento.getId() + "";
        pDTO.pedidoDTO = PedidoDTO.buildDTO(pagamento.getPedido());
        pDTO.cupomDTO = CupomDTO.buildDTO(pagamento.getCupom());
        pDTO.tipoPagamento = pagamento.getTipo().toString();
        pDTO.pagamentoPixDTO = PagamentoPixDTO.buildDTO(pagamento.getPagamentoPix());
        pDTO.pagamentoCartaoDTO = PagamentoCartaoDTO.buildDTO(pagamento.getPagamentoCartao());
        pDTO.pagamentoDinheiroDTO = PagamentoDinheiroDTO.buildDTO(pagamento.getPagamentoDinheiro());
        return pDTO;
    }

    public Pagamento buildEntity() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(Integer.parseInt(id));
        pagamento.setPedido(pedidoDTO.buildEntity());
        pagamento.setCupom(cupomDTO.buildEntity());
        pagamento.setTipo(TipoPagamento.valueOf(tipoPagamento));
        pagamento.setPagamentoPix(pagamentoPixDTO.buildEntity());
        pagamento.setPagamentoCartao(pagamentoCartaoDTO.buildEntity());
        pagamento.setPagamentoDinheiro(pagamentoDinheiroDTO.buildEntity());
        return pagamento;
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
