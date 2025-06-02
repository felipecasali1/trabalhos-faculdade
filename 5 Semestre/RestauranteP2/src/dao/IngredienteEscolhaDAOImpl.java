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
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteEscolha> list() {
        List<IngredienteEscolha> list = new LinkedList<>();
        String sql = "SELECT id FROM public.ingrediente_escolha";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            IngredienteAdicionarDAOImpl ingAdd = new IngredienteAdicionarDAOImpl();
            IngredienteRemoverDAOImpl ingRem = new IngredienteRemoverDAOImpl();
            while(rs.next()) {
                int resId = rs.getInt("id");
                list.add(new IngredienteEscolha(resId, ingAdd.listByEscolhaId(resId), ingRem.listByEscolhaId(resId)));
            }
            
            rs.close();
            ps.close();
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
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
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
            return ie;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(IngredienteEscolha ingEscolha) {
        // A TABELA TEM APENAS ID
    }

    @Override
    public void delete(IngredienteEscolha ingEscolha) {
        String sql = "DELETE FROM public.ingrediente_escolha WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, ingEscolha.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
