package dao;

import connection.ConnectionJDBC;
import models.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public boolean insert(Pagamento pagamento) {
        String sql = "INSERT INTO public.pagamento(tipo, chave_pix, tipo_cartao, valor_recebido, valor_troco, cupom_id, pedido_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pagamento.getTipo().toString());

            if (pagamento.getTipo() == TipoPagamento.PIX && pagamento.getPagamentoPix() != null) {
                ps.setString(2, pagamento.getPagamentoPix().getChavePix());
            } else {
                ps.setNull(2, Types.VARCHAR);
            }

            if (pagamento.getTipo() == TipoPagamento.CARTAO && pagamento.getPagamentoCartao() != null) {
                ps.setString(3, pagamento.getPagamentoCartao().getTipo().toString());
            } else {
                ps.setNull(3, Types.VARCHAR);
            }

            if (pagamento.getTipo() == TipoPagamento.DINHEIRO && pagamento.getPagamentoDinheiro() != null) {
                ps.setFloat(4, pagamento.getPagamentoDinheiro().getValorRecebido());
                ps.setFloat(5, pagamento.getPagamentoDinheiro().getValorTroco());
            } else {
                ps.setNull(4, Types.NUMERIC);
                ps.setNull(5, Types.NUMERIC);
            }

            if (pagamento.getCupom() != null) {
                ps.setInt(6, pagamento.getCupom().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setInt(7, pagamento.getPedido().getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Pagamento> list() {
        List<Pagamento> list = new LinkedList<>();
        String sql = "SELECT id, tipo, chave_pix, tipo_cartao, valor_recebido, valor_troco, cupom_id, pedido_id FROM public.pagamento";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            CupomDAOImpl cupomDAO = new CupomDAOImpl();
            PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
            TipoPagamento tipo = null;
            Pagamento pagamento = null;
            Pedido pedido = null;

            while (rs.next()) {
                int idRes = rs.getInt("id");
                tipo = TipoPagamento.valueOf(rs.getString("tipo").toUpperCase());
                pedido = pedidoDAO.getById(rs.getInt("pedido_id"));

                int cupomId = rs.getInt("cupom_id");
                Cupom cupom = null;
                if (!rs.wasNull()) {
                    cupom = cupomDAO.getById(cupomId);
                }

                switch (tipo) {
                    case PIX:
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, new PagamentoPix(rs.getString("chave_pix")), null, null);
                        break;
                    case CARTAO:
                        TipoPagamentoCartao tipoCartao = TipoPagamentoCartao.valueOf(rs.getString("tipo_cartao").toUpperCase());
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, null, new PagamentoCartao(tipoCartao), null);
                        break;
                    case DINHEIRO:
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, null, null, new PagamentoDinheiro(idRes, rs.getFloat("valor_recebido"), rs.getFloat("valor_troco")));
                        break;
                }

                list.add(pagamento);
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pagamento getByPedidoId(Integer pedidoId) {
        String sql = "SELECT id, tipo, chave_pix, tipo_cartao, valor_recebido, valor_troco, cupom_id, pedido_id FROM public.pagamento WHERE pedido_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pedidoId);
            ResultSet rs = ps.executeQuery();

            CupomDAOImpl cupomDAO = new CupomDAOImpl();
            PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
            TipoPagamento tipo = null;
            Pagamento pagamento = null;
            Pedido pedido = null;

            if (rs.next()) {
                int idRes = rs.getInt("id");
                tipo = TipoPagamento.valueOf(rs.getString("tipo").toUpperCase());
                pedido = pedidoDAO.getById(rs.getInt("pedido_id"));

                int cupomId = rs.getInt("cupom_id");
                Cupom cupom = null;
                if (!rs.wasNull()) {
                    cupom = cupomDAO.getById(cupomId);
                }

                switch (tipo) {
                    case PIX:
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, new PagamentoPix(rs.getString("chave_pix")), null, null);
                        break;
                    case CARTAO:
                        TipoPagamentoCartao tipoCartao = TipoPagamentoCartao.valueOf(rs.getString("tipo_cartao").toUpperCase());
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, null, new PagamentoCartao(tipoCartao), null);
                        break;
                    case DINHEIRO:
                        pagamento = new Pagamento(idRes, pedido, cupom, tipo, null, null, new PagamentoDinheiro(idRes, rs.getFloat("valor_recebido"), rs.getFloat("valor_troco")));
                        break;
                }
            }

            rs.close();
            ps.close();
            return pagamento;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Pagamento pagamento) {
        String sql = "UPDATE public.pagamento SET tipo = ?, chave_pix = ?, tipo_cartao = ?, valor_recebido = ?, valor_troco = ?, cupom_id = ?, pedido_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pagamento.getTipo().toString());

            if (pagamento.getTipo() == TipoPagamento.PIX && pagamento.getPagamentoPix() != null) {
                ps.setString(2, pagamento.getPagamentoPix().getChavePix());
            } else {
                ps.setNull(2, Types.VARCHAR);
            }

            if (pagamento.getTipo() == TipoPagamento.CARTAO && pagamento.getPagamentoCartao() != null) {
                ps.setString(3, pagamento.getPagamentoCartao().getTipo().toString());
            } else {
                ps.setNull(3, Types.VARCHAR);
            }

            if (pagamento.getTipo() == TipoPagamento.DINHEIRO && pagamento.getPagamentoDinheiro() != null) {
                ps.setFloat(4, pagamento.getPagamentoDinheiro().getValorRecebido());
                ps.setFloat(5, pagamento.getPagamentoDinheiro().getValorTroco());
            } else {
                ps.setNull(4, Types.NUMERIC);
                ps.setNull(5, Types.NUMERIC);
            }

            if (pagamento.getCupom() != null) {
                ps.setInt(6, pagamento.getCupom().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setInt(7, pagamento.getPedido().getId());
            ps.setInt(8, pagamento.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Pagamento pagamento) {
        String sql = "DELETE FROM public.pagamento WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, pagamento.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
