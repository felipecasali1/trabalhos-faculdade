package dao;

import connection.ConnectionJDBC;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Bairro;
import java.sql.*;
import java.util.LinkedList;

public class BairroDAOImpl implements BairroDAO {

    @Override
    public void insert(Bairro bairro) {
        String sql = "INSERT INTO public.bairro(nome) VALUES (?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bairro.getNome());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Bairro> list() {
        List<Bairro> list = new LinkedList<>();
        String sql = "SELECT id, nome FROM public.bairro";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                list.add(new Bairro(rs.getInt("id"), rs.getString("nome")));
            }
            
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Bairro getById(Integer id) {
        String sql = "SELECT id, nome FROM public.bairro WHERE id = ?";        
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Bairro bairro = null;
            if (rs.next()) {
                bairro = new Bairro(rs.getInt("id"), rs.getString("nome"));
            }
            
            rs.close();
            ps.close();
            return bairro;
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Bairro bairro) {
        String sql = "UPDATE public.bairro SET nome = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bairro.getNome());
            ps.setInt(2, bairro.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Bairro bairro) {
        String sql = "DELETE FROM public.bairro WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, bairro.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
