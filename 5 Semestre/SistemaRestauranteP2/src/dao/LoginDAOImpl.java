package dao;

import connection.ConnectionJDBC;
import models.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public void insert(Login login) {
        String sql = "INSERT INTO public.login(usuario, senha) VALUES (?, ?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getSenha());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Login> list() {
        List<Login> list = new LinkedList<>();
        String sql = "SELECT id, numero, ddd, cliente_id, funcionario_id FROM public.telefone";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Login(idRes, rs.getString("usuario"), rs.getString("senha")));
            }

            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Login getById(Integer id) {
        List<Login> list = new LinkedList<>();
        String sql = "SELECT id, numero, ddd, cliente_id, funcionario_id FROM public.telefone WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Login login = null;
            if(rs.next()) {
                int idRes = rs.getInt("id");
                login = new Login(idRes, rs.getString("usuario"), rs.getString("senha"));
            }

            rs.close();
            ps.close();
            c.close();
            return login;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Login login) {
        String sql = "UPDATE public.login SET usuario = ?, senha = ? WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getSenha());
            ps.setInt(3, login.getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Login login) {
        String sql = "DELETE FROM public.login WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, login.getId());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
