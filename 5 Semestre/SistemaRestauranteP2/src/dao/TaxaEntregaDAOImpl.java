package dao;

import connection.ConnectionJDBC;
import models.TaxaEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaxaEntregaDAOImpl implements TaxaEntregaDAO {
    @Override
    public boolean insert(TaxaEntrega taxaEntrega) {
        String sql = "INSERT INTO public.taxa_entrega(taxa, entrega_id) VALUES (?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, taxaEntrega.getTaxa());
            ps.setInt(2, taxaEntrega.getEntrega().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<TaxaEntrega> list() {
        List<TaxaEntrega> list = new LinkedList<>();
        String sql = "SELECT id, taxa, entrega_id FROM public.taxa_entrega";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            TaxaEntrega taxaEntrega = null;
            EntregaDAOImpl entregaDAO = new EntregaDAOImpl();
            while (rs.next()) {
                int idRes = rs.getInt("id");
                list.add(new TaxaEntrega(idRes, rs.getFloat("taxa"), entregaDAO.getById(rs.getInt("entrega_id"))));
            }

            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public TaxaEntrega getByEntregaId(Integer entregaId) {
        String sql = "SELECT id, taxa, entrega_id FROM public.taxa_entrega WHERE entrega_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, entregaId);
            ResultSet rs = ps.executeQuery();

            TaxaEntrega taxaEntrega = null;
            EntregaDAOImpl entregaDAO = new EntregaDAOImpl();
            if(rs.next()) {
                int idRes = rs.getInt("id");
                taxaEntrega = new TaxaEntrega(idRes, rs.getFloat("taxa"), entregaDAO.getById(entregaId));
            }

            rs.close();
            ps.close();
            return taxaEntrega;
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(TaxaEntrega taxaEntrega) {
        String sql = "UPDATE public.taxa_entrega SET taxa = ?, entrega_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, taxaEntrega.getTaxa());
            ps.setInt(2, taxaEntrega.getEntrega().getId());
            ps.setInt(3, taxaEntrega.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TaxaEntrega taxaEntrega) {
        String sql = "DELETE FROM public.taxa_entrega WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, taxaEntrega.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
