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
    public void insert(Telefone telefone) {
        String sql = "INSERT INTO public.cliente(numero, ddd, cliente_id) VALUES (?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, telefone.getNumero());
            ps.setString(2, telefone.getDdd());
            ps.setInt(3, telefone.getCliente().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), clienteDAO.getById(rs.getInt("cliente_id")), funcionarioDAO.getById(rs.getInt("funcionario_id"))));
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
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), clienteDAO.getById(rs.getInt("cliente_id")), null));
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
                list.add(new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), null, funcionarioDAO.getById(rs.getInt("funcionario_id"))));
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
                telefone = new Telefone(idRes, rs.getString("numero"), rs.getString("ddd"), clienteDAO.getById(rs.getInt("cliente_id")), funcionarioDAO.getById(rs.getInt("funcionario_id")));
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
    public void update(Telefone telefone) {
        String sql = "UPDATE public.telefone SET numero = ?, ddd = ?, cliente_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, telefone.getNumero());
            ps.setString(2, telefone.getDdd());
            ps.setInt(3, telefone.getCliente().getId());
            ps.setInt(4, telefone.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Telefone telefone) {
        String sql = "DELETE FROM public.telefone WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, telefone.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
