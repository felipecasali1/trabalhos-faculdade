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
        String sql = "INSERT INTO public.carrinho DEFAULT VALUES";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Carrinho> list() {
        List<Carrinho> list = new LinkedList<>();
        String sql = "SELECT id FROM public.carrinho";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            CarrinhoProdutoDAOImpl cpDAO = new CarrinhoProdutoDAOImpl();
            while(rs.next()) {
                int id = rs.getInt("id");
                list.add(new Carrinho(id, cpDAO.listByCarrinhoId(id)));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Carrinho getById(Integer id) {
        String sql = "SELECT id FROM public.carrinho WHERE id = ?";        
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Carrinho carrinho = null;
            CarrinhoProdutoDAOImpl cpDAO = new CarrinhoProdutoDAOImpl();
            if(rs.next()) {
                int idRes = rs.getInt("id");
                carrinho = new Carrinho(idRes, cpDAO.listByCarrinhoId(idRes));
            }
            
            rs.close();
            ps.close();
            c.close();
            return carrinho;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Carrinho carrinho) {
        // A TABELA TEM APENAS ID
    }

    @Override
    public void delete(Carrinho carrinho) {
        String sql = "DELETE FROM public.carrinho WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, carrinho.getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();          
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
