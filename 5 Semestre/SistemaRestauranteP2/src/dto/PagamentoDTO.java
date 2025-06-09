package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Pagamento;
import models.TipoPagamento;

public class PagamentoDTO extends InterfaceDTO {
    public PedidoDTO pedidoDTO;
    public CupomDTO cupomDTO;
    public String tipoPagamento;
    public PagamentoPixDTO pagamentoPixDTO;
    public PagamentoCartaoDTO pagamentoCartaoDTO;
    public PagamentoDinheiroDTO pagamentoDinheiroDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Pagamento) e);
    }

    public static PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO pDTO = new PagamentoDTO();
        pDTO.id = pagamento.getId() + "";
        pDTO.pedidoDTO = PedidoDTO.toDTO(pagamento.getPedido());
        pDTO.cupomDTO = CupomDTO.toDTO(pagamento.getCupom());
        pDTO.tipoPagamento = pagamento.getTipo().toString();
        pDTO.pagamentoPixDTO = PagamentoPixDTO.toDTO(pagamento.getPagamentoPix());
        pDTO.pagamentoCartaoDTO = PagamentoCartaoDTO.toDTO(pagamento.getPagamentoCartao());
        pDTO.pagamentoDinheiroDTO = PagamentoDinheiroDTO.toDTO(pagamento.getPagamentoDinheiro());
        return pDTO;
    }

    @Override
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
        return new String[]{"Id", "Pedido", "Cupom", "Tipo Pagamento"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, pedidoDTO.data, cupomDTO.codigo, tipoPagamento};
    }
}
