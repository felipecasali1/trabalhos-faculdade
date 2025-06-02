package dao;

import connection.ConnectionJDBC;
import models.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public void insert(Delivery delivery) {
        String sql = "INSERT INTO public.cupom(numero, complemento, endereco_id) VALUES (?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, delivery.getNumero());
            ps.setString(2, delivery.getComplemento());
            ps.setInt(3, delivery.getEndereco().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Delivery> list() {
        List<Delivery> list = new LinkedList<>();
        String sql = "SELECT id, numero, complemento, endereco_id FROM public.cupom";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            EnderecoDAOImpl enderecoDAO = new EnderecoDAOImpl();
            while(rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Delivery(idRes, rs.getString("numero"), rs.getString("complemento"), enderecoDAO.getById(rs.getInt("endereco_id"))));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Delivery getById(Integer id) {
        String sql = "SELECT id, numero, complemento, endereco_id FROM public.cupom WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Delivery delivery = null;
            EnderecoDAOImpl enderecoDAO = new EnderecoDAOImpl();
            if (rs.next()) {
                int idRes = rs.getInt("id");
                delivery = new Delivery(idRes, rs.getString("numero"), rs.getString("complemento"), enderecoDAO.getById(rs.getInt("endereco_id")));
            }

            rs.close();
            ps.close();
            return delivery;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Delivery delivery) {
        String sql = "UPDATE public.delivery SET numero = ?, complemento = ?, endereco_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, delivery.getNumero());
            ps.setString(2, delivery.getComplemento());
            ps.setInt(3, delivery.getEndereco().getId());
            ps.setInt(4, delivery.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Delivery delivery) {
        String sql = "DELETE FROM public.delivery WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, delivery.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
