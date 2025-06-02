package dao;

import connection.ConnectionJDBC;
import models.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAOImpl implements EnderecoDAO {
    @Override
    public void insert(Endereco endereco) {
        String sql = "INSERT INTO public.endereco(rua, cep, bairro_id, distancia) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCep());
            ps.setInt(3, endereco.getBairro().getId());
            ps.setFloat(4, endereco.getDistancia());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Endereco> list() {
        List<Endereco> list = new LinkedList<>();
        String sql = "SELECT id, rua, cep, bairro_id, distancia FROM public.cupom";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            BairroDAOImpl bairroDAO = new BairroDAOImpl();
            while(rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new Endereco(idRes, rs.getString("rua"), rs.getString("cep"), bairroDAO.getById(rs.getInt("bairro_id")), rs.getFloat("distancia")));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Endereco getById(Integer id) {
        List<Endereco> list = new LinkedList<>();
        String sql = "SELECT id, rua, cep, bairro_id, distancia FROM public.cupom WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Endereco endereco = null;
            BairroDAOImpl bairroDAO = new BairroDAOImpl();
            if (rs.next()) {
                int idRes = rs.getInt("id");
                endereco = new Endereco(idRes, rs.getString("rua"), rs.getString("cep"), bairroDAO.getById(rs.getInt("bairro_id")), rs.getFloat("distancia"));
            }

            rs.close();
            ps.close();
            return endereco;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Endereco endereco) {
        String sql = "UPDATE public.endereco SET rua = ?, cep = ?, bairro_id = ?, distancia = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCep());
            ps.setInt(3, endereco.getBairro().getId());
            ps.setFloat(4, endereco.getDistancia());
            ps.setInt(5, endereco.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Endereco endereco) {
        String sql = "DELETE FROM public.endereco WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, endereco.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
