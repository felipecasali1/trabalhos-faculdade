package dao;

import connection.ConnectionJDBC;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public boolean insert(Cliente cliente) {
        String sql = "INSERT INTO public.cliente(nome) VALUES (?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Cliente> list() {
        List<Cliente> list = new LinkedList<>();
        String sql = "SELECT id, nome FROM public.cliente";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            TelefoneDAOImpl telDAO = new TelefoneDAOImpl();
            while(rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Cliente(idRes, rs.getString("nome"), telDAO.listIdsByClienteId(idRes)));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Cliente getById(Integer id) {
        String sql = "SELECT id, nome FROM public.cliente WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Cliente cliente = null;
            TelefoneDAOImpl telDAO = new TelefoneDAOImpl();
            if(rs.next()) {
                int idRes = rs.getInt("id");
                cliente = new Cliente(idRes, rs.getString("nome"), telDAO.listIdsByClienteId(idRes));
            }

            rs.close();
            ps.close();
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Cliente cliente) {
        String sql = "UPDATE public.cliente SET nome = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Cliente cliente) {
        String sql = "DELETE FROM public.cliente WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, cliente.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
