package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionJDBC;
import models.*;

public class IngredienteAdicionarDAOImpl implements IngredienteAdicionarDAO {

    @Override
    public boolean insert(IngredienteAdicionar ingAdd) {
        String sql = "INSERT INTO public.ingrediente_adicionar(nome, valor, ing_escolha_id) VALUES (?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, ingAdd.getNome());
            ps.setFloat(2, ingAdd.getValor());
            ps.setInt(3, ingAdd.getIngEscolha().getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<IngredienteAdicionar> list() {
        List<IngredienteAdicionar> list = new LinkedList<>();
        String sql = "SELECT id, nome, valor, ing_escolha_id FROM public.ingrediente_adicionar";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            while(rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new IngredienteAdicionar(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), ingEscolha));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IngredienteAdicionar getById(Integer id) {
        String sql = "SELECT id, nome, valor, ing_escolha_id FROM public.ingrediente_adicionar WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            IngredienteAdicionar ia = null;
            if(rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                ia = new IngredienteAdicionar(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), ingEscolha);
            }

            rs.close();
            ps.close();
            return ia;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IngredienteAdicionar> listByEscolhaId(Integer escolhaId) {
        List<IngredienteAdicionar> list = new LinkedList<>();
        String sql = "SELECT id, nome, valor, ing_escolha_id FROM public.ingrediente_adicionar WHERE ing_escolha_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, escolhaId);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            if(rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new IngredienteAdicionar(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), ingEscolha));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(IngredienteAdicionar ingAdd) {
        String sql = "UPDATE public.ingrediente_adicionar SET nome = ?, valor = ?, ing_escolha_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, ingAdd.getNome());
            ps.setFloat(2, ingAdd.getValor());
            ps.setInt(3, ingAdd.getIngEscolha().getId());
            ps.setInt(4, ingAdd.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(IngredienteAdicionar ingAdd) {
        String sql = "DELETE FROM public.ingrediente_adicionar WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, ingAdd.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
