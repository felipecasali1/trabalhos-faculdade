package dao;

import connection.ConnectionJDBC;
import models.Entrega;
import models.TipoEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntregaDAOImpl implements EntregaDAO {
    @Override
    public boolean insert(Entrega entrega) {
        String sql = "INSERT INTO public.entrega(cliente_id, delivery_id, pedido_id, tipo) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, entrega.getCliente().getId());
            ps.setInt(2, entrega.getDelivery().getId());
            ps.setInt(3, entrega.getPedido().getId());
            ps.setString(4, entrega.getTipo().toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Entrega> list() {
        List<Entrega> list = new LinkedList<>();
        String sql = "SELECT id, cliente_id, delivery_id, pedido_id, tipo FROM public.entrega";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            DeliveryDAOImpl deliveryDAO = new DeliveryDAOImpl();
            PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
            TipoEntrega tipo = null;
            while(rs.next()) {
                int idRes = rs.getInt("id");
                tipo = TipoEntrega.valueOf(rs.getString("tipo").toUpperCase());
                list.add(new Entrega(idRes, clienteDAO.getById(rs.getInt("cliente_id")), tipo, deliveryDAO.getById(rs.getInt("delivery_id")), pedidoDAO.getById(rs.getInt("pedido_id"))));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Entrega getById(Integer id) {
        String sql = "SELECT id, cliente_id, delivery_id, pedido_id, tipo FROM public.entrega WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Entrega entrega = null;
            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            DeliveryDAOImpl deliveryDAO = new DeliveryDAOImpl();
            PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
            TipoEntrega tipo = null;
            if (rs.next()) {
                int idRes = rs.getInt("id");
                tipo = TipoEntrega.valueOf(rs.getString("tipo").toUpperCase());
                entrega = new Entrega(idRes, clienteDAO.getById(rs.getInt("cliente_id")), tipo, deliveryDAO.getById(rs.getInt("delivery_id")), pedidoDAO.getById(rs.getInt("pedido_id")));
            }

            rs.close();
            ps.close();
            return entrega;
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Entrega entrega) {
        String sql = "UPDATE public.entrega SET cliente_id = ?, delivery_id = ?, pedido_id = ?, tipo = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, entrega.getCliente().getId());
            ps.setInt(2, entrega.getDelivery().getId());
            ps.setInt(3, entrega.getPedido().getId());
            ps.setString(4, entrega.getTipo().toString());
            ps.setInt(5, entrega.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Entrega entrega) {
        String sql = "DELETE FROM public.entrega WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, entrega.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
