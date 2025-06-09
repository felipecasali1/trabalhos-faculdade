package dao;

import connection.ConnectionJDBC;
import models.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    @Override
    public boolean insert(Funcionario funcionario) {
        String sql = "INSERT INTO public.funcionario(nome, cpf, rg, login_id) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setInt(4, funcionario.getLogin().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Funcionario> list() {
        List<Funcionario> list = new LinkedList<>();
        String sql = "SELECT id, nome, cpf, rg, login_id FROM public.funcionario";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            LoginDAOImpl loginDAO = new LoginDAOImpl();
            TelefoneDAOImpl telefoneDAO = new TelefoneDAOImpl();
            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Funcionario(idRes, rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), loginDAO.getById(rs.getInt("login_id")), telefoneDAO.listIdsByFuncionarioId(rs.getInt(idRes))));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Funcionario getById(Integer id) {
        String sql = "SELECT id, nome, cpf, rg, login_id FROM public.funcionario WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Funcionario funcionario = null;
            LoginDAOImpl loginDAO = new LoginDAOImpl();
            TelefoneDAOImpl telefoneDAO = new TelefoneDAOImpl();
            if(rs.next()) {
                int idRes = rs.getInt("id");
                funcionario = new Funcionario(idRes, rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), loginDAO.getById(rs.getInt("login_id")), telefoneDAO.listIdsByFuncionarioId(rs.getInt(idRes)));
            }

            rs.close();
            ps.close();
            return funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Funcionario funcionario) {
        String sql = "UPDATE public.funcionario SET nome = ?, cpf = ?, rg = ?, login_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setInt(4, funcionario.getLogin().getId());
            ps.setInt(5, funcionario.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Funcionario funcionario) {
        String sql = "DELETE FROM public.funcionario WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
