package dao;

import connection.ConnectionJDBC;
import models.IngredienteEscolha;
import models.IngredienteRemover;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredienteRemoverDAOImpl implements IngredienteRemoverDAO {
    @Override
    public void insert(IngredienteRemover ingRem) {
        String sql = "INSERT INTO public.ingrediente_remover(nome, ing_escolha_id) VALUES (?, ?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, ingRem.getNome());
            ps.setInt(2, ingRem.getEscolha().getId());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteRemover> list() {
        List<IngredienteRemover> list = new LinkedList<>();
        String sql = "SELECT id, nome, ing_escolha_id FROM public.ingrediente_remover";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            while(rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new IngredienteRemover(rs.getInt("id"), rs.getString("nome"), ingEscolha));
            }

            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IngredienteRemover getById(Integer id) {
        String sql = "SELECT id, nome, ing_escolha_id FROM public.ingrediente_remover WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            IngredienteRemover ir = null;
            if(rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                ir = new IngredienteRemover(rs.getInt("id"), rs.getString("nome"), ingEscolha);
            }

            rs.close();
            ps.close();
            c.close();
            return ir;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IngredienteRemover> listByEscolhaId(Integer escolhaId) {
        List<IngredienteRemover> list = new LinkedList<>();
        String sql = "SELECT id, nome, ing_escolha_id FROM public.ingrediente_remover WHERE ing_escolha_id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, escolhaId);
            ResultSet rs = ps.executeQuery();

            IngredienteEscolha ingEscolha = null;
            while (rs.next()) {
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new IngredienteRemover(rs.getInt("id"), rs.getString("nome"), ingEscolha));
            }

            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(IngredienteRemover ingRem) {
        String sql = "UPDATE public.ingrediente_remover SET nome = ?, ing_escolha_id = ? WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, ingRem.getNome());
            ps.setInt(2, ingRem.getEscolha().getId());
            ps.setInt(3, ingRem.getId());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(IngredienteRemover ingRem) {
        String sql = "DELETE FROM public.ingrediente_remover WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, ingRem.getId());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
