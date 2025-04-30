package dao;

import connection.ConnectionJDBC;
import java.util.List;
import models.Carrinho;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.LinkedList;

public class CarrinhoDAOImpl implements CarrinhoDAO {

    @Override
    public void insert(Carrinho carrinho) {
        String sql = "INSERT INTO public.carrinho(quantidade, ) VALUES (?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinho.getId());
            ps.executeUpdate();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Carrinho> list() {
        List<Carrinho> list = new LinkedList<>();
        String sql = "SELECT * FROM public.carrinho";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            c.close();
            while(rs.next()) {
                int id = rs.getInt("id");
                list.add(new Carrinho(id));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Carrinho getById(Integer id) {
        
    }

    @Override
    public void update(Carrinho carrinho) {
        String sql = "UPDATE public.carrinho SET nome = ? WHERE id = ?";
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
    public void delete(Carrinho carrinho) {
        
    }    
}
