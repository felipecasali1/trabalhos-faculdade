package dao;

import connection.ConnectionJDBC;
import models.Cupom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupomDAOImpl implements CupomDAO {
    @Override
    public boolean insert(Cupom cupom) {
        String sql = "INSERT INTO public.cupom(porcentagem, codigo, validade, ativo) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, cupom.getPorcentagem());
            ps.setString(2, cupom.getCodigo());
            ps.setTimestamp(3, cupom.getValidade());
            ps.setBoolean(4, cupom.isAtivo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Cupom> list() {
        List<Cupom> list = new LinkedList<>();
        String sql = "SELECT id, porcentagem, codigo, validade, ativo FROM public.cupom";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Cupom(idRes, rs.getFloat("portcentagem"), rs.getString("codigo"), rs.getTimestamp("validade"), rs.getBoolean("ativo")));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Cupom getById(Integer id) {
        String sql = "SELECT id, porcentagem, codigo, validade, ativo FROM public.cupom WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Cupom cupom = null;
            while(rs.next()) {
                int idRes = rs.getInt("id");
                cupom = new Cupom(idRes, rs.getFloat("portcentagem"), rs.getString("codigo"), rs.getTimestamp("validade"), rs.getBoolean("ativo"));
            }

            rs.close();
            ps.close();
            return cupom;
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Cupom cupom) {
        String sql = "UPDATE public.cupom SET porcentagem = ?, codigo = ?, validade = ?, ativo = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, cupom.getPorcentagem());
            ps.setString(2, cupom.getCodigo());
            ps.setTimestamp(3, cupom.getValidade());
            ps.setBoolean(4, cupom.isAtivo());
            ps.setInt(5, cupom.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Cupom cupom) {
        String sql = "DELETE FROM public.cupom WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, cupom.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CupomDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
