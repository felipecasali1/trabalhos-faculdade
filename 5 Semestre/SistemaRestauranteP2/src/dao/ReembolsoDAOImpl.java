package dao;

import connection.ConnectionJDBC;
import models.Reembolso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReembolsoDAOImpl implements ReembolsoDAO {
    @Override
    public boolean insert(Reembolso reembolso) {
        String sql = "INSERT INTO public.reembolso(motivo) VALUES (?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, reembolso.getMotivo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Reembolso> list() {
        List<Reembolso> list = new LinkedList<>();
        String sql = "SELECT id, motivo FROM public.reembolso";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Reembolso reembolso = null;
            while(rs.next()) {
                list.add(new Reembolso(rs.getInt("id"), rs.getString("motivo")));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Reembolso getById(Integer id) {
        String sql = "SELECT id, status FROM public.reembolso WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Reembolso reembolso = null;
            if (rs.next()) {
                reembolso = new Reembolso(rs.getInt("id"), rs.getString("motivo"));
            }

            rs.close();
            ps.close();
            return reembolso;
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Reembolso reembolso) {
        String sql = "UPDATE public.reembolso SET motivo = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, reembolso.getMotivo());
            ps.setInt(2, reembolso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Reembolso reembolso) {
        String sql = "DELETE FROM public.reembolso WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, reembolso.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
