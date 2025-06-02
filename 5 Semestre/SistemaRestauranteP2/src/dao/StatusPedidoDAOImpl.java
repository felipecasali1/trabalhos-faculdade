package dao;

import connection.ConnectionJDBC;
import models.Status;
import models.StatusPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusPedidoDAOImpl implements StatusPedidoDAO {
    @Override
    public boolean insert(StatusPedido statusPedido) {
        String sql = "INSERT INTO public.status_pedido(status) VALUES (?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, statusPedido.getStatus().toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<StatusPedido> list() {
        List<StatusPedido> list = new LinkedList<>();
        String sql = "SELECT id, status FROM public.status_pedido";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Status status = null;
            while(rs.next()) {
                int idRes = rs.getInt("id");
                status = Status.valueOf(rs.getString(rs.getString("status")).toUpperCase());
                list.add(new StatusPedido(idRes, status));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StatusPedido getById(Integer id) {
        String sql = "SELECT id, status FROM public.status_pedido WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            StatusPedido statusPedido = null;
            Status status = null;
            if (rs.next()) {
                status = Status.valueOf(rs.getString(rs.getString("status")).toUpperCase());
                statusPedido = new StatusPedido(rs.getInt("id"), status);
            }

            rs.close();
            ps.close();
            return statusPedido;
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(StatusPedido statusPedido) {
        String sql = "UPDATE public.status_pedido SET status = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, statusPedido.getStatus().toString());
            ps.setInt(2, statusPedido.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(StatusPedido statusPedido) {
        String sql = "DELETE FROM public.status_pedido WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, statusPedido.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
