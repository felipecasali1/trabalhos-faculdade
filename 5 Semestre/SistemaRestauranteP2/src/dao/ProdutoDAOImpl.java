package dao;

import models.Produto;
import java.util.List;
import connection.ConnectionJDBC;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.LinkedList;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void insert(Produto produto) {
        String sql = "INSERT INTO public.produto(valor, nome) VALUES (?, ?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, produto.getValorUnitario());
            ps.setString(2, produto.getNome());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produto> list() {
        List<Produto> list = new LinkedList<>();
        String sql = "SELECT id, valor, nome FROM public.produto";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {  
                list.add(new Produto(rs.getInt("id"), rs.getFloat("valor"), rs.getString("nome")));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Produto getById(Integer id) {
        String sql = "SELECT id, valor, nome FROM public.produto WHERE id = ?";
        try {    
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Produto p = null;
            if(rs.next()) {
                p = new Produto(rs.getInt("id"), rs.getFloat("valor"), rs.getString("nome"));
            }
            
            rs.close();
            ps.close();
            c.close();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Produto produto) {
        String sql = "UPDATE public.produto SET valor = ?, nome = ? WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, produto.getValorUnitario());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Produto produto) {
        String sql = "DELETE FROM public.produto WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, produto.getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();          
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
