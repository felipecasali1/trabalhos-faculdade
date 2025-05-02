package dao;

import java.util.List;
import models.IngredienteEscolha;
import connection.ConnectionJDBC;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.LinkedList;

public class IngredienteEscolhaDAOImpl implements IngredienteEscolhaDAO {

    @Override
    public void insert(IngredienteEscolha ingEscolha) {
        String sql = "INSERT INTO public.produto DEFAULT VALUES";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteEscolha> list() {
        List<IngredienteEscolha> list = new LinkedList<>();
        String sql = "SELECT id FROM public.ingrediente_escolha";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            IngredienteAdicionarDAOImpl ingAdd = new IngredienteAdicionarDAOImpl();
            IngredienteRemoverDAOImpl ingRem = new IngredienteRemoverDAOImpl();
            while(rs.next()) {
                list.add(new IngredienteEscolha(rs.getInt("id"), ingAdd.listByEscolhaId(), ingRem.listByEscolhaId()));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IngredienteEscolha getById(Integer id) {
        String sql = "SELECT id FROM public.ingrediente_escolha WHERE id = ?";        
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            IngredienteEscolha ie = null;
            IngredienteAdicionarDAOImpl ingAdd = new IngredienteAdicionarDAOImpl();
            IngredienteRemoverDAOImpl ingRem = new IngredienteRemoverDAOImpl();
            if(rs.next()) {
                int resId = rs.getInt("id");
                ie = new IngredienteEscolha(resId, ingAdd.listByEscolhaId(resId), ingRem.listByEscolhaId(resId));
            }
            
            rs.close();
            ps.close();
            c.close();
            return ie;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(IngredienteEscolha ingEscolha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(IngredienteEscolha ingEscolha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
