package dao;

import connection.ConnectionJDBC;
import java.sql.SQLException;
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
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bairro.getNome());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Bairro> list() {
        List<Bairro> list = new LinkedList<>();
        String sql = "SELECT * FROM public.bairro";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                list.add(new Bairro(id, nome));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Bairro getById(Integer id) {
        String sql = "SELECT * FROM public.bairro WHERE id = ?";        
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Bairro bairro = null;
            if(rs.next()) {
                bairro = new Bairro(rs.getInt("id"), rs.getString("nome"));
            }
            
            rs.close();
            ps.close();
            c.close();
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
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bairro.getNome());
            ps.setInt(2, bairro.getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Bairro bairro) {
        String sql = "DELETE FROM public.bairro WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, bairro.getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
