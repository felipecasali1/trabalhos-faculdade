package dao;

import connection.ConnectionJDBC;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void insert(Pedido pedido) {
        String sql = "INSERT INTO public.pedido(data, cliente_id, carrinho_id, status_pedido_id, reembolso_id) VALUES (?, ?, ?, ?, ?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setTimestamp(1, pedido.getData());
            ps.setInt(2, pedido.getCliente().getId());
            ps.setInt(3, pedido.getCarrinho().getId());
            ps.setInt(4, pedido.getStatus().getId());
            ps.setInt(5, pedido.getReembolso().getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pedido> list() {
        List<Pedido> list = new LinkedList<>();
        String sql = "SELECT id, data, cliente_id, carrinho_id, status_pedido_id, reembolso_id FROM public.pedido";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            CarrinhoDAOImpl carrinhoDAO = new CarrinhoDAOImpl();
            StatusPedidoDAOImpl statusPedidoDAO = new StatusPedidoDAOImpl();
            ReembolsoDAOImpl reembolsoDAO = new ReembolsoDAOImpl();
            while(rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Pedido(
                    idRes,
                    rs.getTimestamp("data"),
                    clienteDAO.getById(rs.getInt("cliente_id")),
                    carrinhoDAO.getById(rs.getInt("carrinho_id")),
                    statusPedidoDAO.getById(rs.getInt("status_pedido_id")),
                    reembolsoDAO.getById(rs.getInt("reembolso_id"))
                ));
            }

            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pedido getById(Integer id) {
        String sql = "SELECT id, data, cliente_id, carrinho_id, status_pedido_id, reembolso_id FROM public.pedido WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            CarrinhoDAOImpl carrinhoDAO = new CarrinhoDAOImpl();
            StatusPedidoDAOImpl statusPedidoDAO = new StatusPedidoDAOImpl();
            ReembolsoDAOImpl reembolsoDAO = new ReembolsoDAOImpl();
            Pedido pedido = null;
            if (rs.next()) {
                pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getTimestamp("data"),
                    clienteDAO.getById(rs.getInt("cliente_id")),
                    carrinhoDAO.getById(rs.getInt("carrinho_id")),
                    statusPedidoDAO.getById(rs.getInt("status_pedido_id")),
                    reembolsoDAO.getById(rs.getInt("reembolso_id"))
                );
            }

            rs.close();
            ps.close();
            c.close();
            return pedido;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Pedido pedido) {
        String sql = "UPDATE public.pedido SET data = ?, cliente_id = ?, carrinho_id = ?, status_pedido_id = ?, reembolso_id = ? WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setTimestamp(1, pedido.getData());
            ps.setInt(2, pedido.getCliente().getId());
            ps.setInt(3, pedido.getCarrinho().getId());
            ps.setInt(4, pedido.getStatus().getId());
            ps.setInt(5, pedido.getReembolso().getId());
            ps.setInt(6, pedido.getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Pedido pedido) {
        String sql = "DELETE FROM public.pedido WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, pedido.getId());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
