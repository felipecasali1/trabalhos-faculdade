package dao;

import connection.ConnectionJDBC;
import models.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneDAOImpl implements TelefoneDAO {
    @Override
    public boolean insert(Telefone telefone) {
        String sql = "INSERT INTO public.telefone(numero, ddd, cliente_id, funcionario_id) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, telefone.getNumero());
            ps.setString(2, telefone.getDdd());
            if (telefone.getClienteId()!= null) {
                ps.setInt(3, telefone.getClienteId());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            if (telefone.getFuncionarioId()!= null) {
                ps.setInt(4, telefone.getFuncionarioId());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Telefone> list() {
        List<Telefone> list = new LinkedList<>();
        String sql = "SELECT id, numero, ddd, cliente_id, funcionario_id FROM public.telefone";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), rs.getInt("cliente_id"), rs.getInt("funcionario_id")));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Telefone> listByClienteId(Integer clienteId) {
        List<Telefone> list = new LinkedList<>();
        String sql = "SELECT id, numero, ddd, cliente_id FROM public.telefone WHERE cliente_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, clienteId);
            ResultSet rs = ps.executeQuery();

            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), rs.getInt("cliente_id"), null));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Telefone> listByFuncionarioId(Integer funcionarioId) {
        List<Telefone> list = new LinkedList<>();
        String sql = "SELECT id, numero, ddd, funcionario_id FROM public.telefone WHERE funcionario_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, funcionarioId);
            ResultSet rs = ps.executeQuery();

            FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), null, rs.getInt("funcionario_id")));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Integer> listIdsByClienteId(int clienteId) {
        List<Integer> ids = new LinkedList<>();
        String sql = "SELECT id FROM public.telefone WHERE cliente_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, clienteId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }

            rs.close();
            ps.close();
            return ids;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Integer> listIdsByFuncionarioId(int funcionarioId) {
        List<Integer> ids = new LinkedList<>();
        String sql = "SELECT id FROM public.telefone WHERE funcionario_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, funcionarioId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }

            rs.close();
            ps.close();
            return ids;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Telefone getById(Integer id) {
        String sql = "SELECT id, numero, ddd, cliente_id FROM public.telefone WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Telefone telefone = null;
            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
            if(rs.next()) {
                int idRes = rs.getInt("id");
                telefone = new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), rs.getInt("cliente_id"), rs.getInt("funcionario_id"));
            }

            rs.close();
            ps.close();
            return telefone;
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Telefone telefone) {
        String sql = "UPDATE public.telefone SET numero = ?, ddd = ?, cliente_id = ? funcionario_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, telefone.getNumero());
            ps.setString(2, telefone.getDdd());
            ps.setInt(3, telefone.getClienteId());
            ps.setInt(4, telefone.getFuncionarioId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Telefone telefone) {
        String sql = "DELETE FROM public.telefone WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, telefone.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
