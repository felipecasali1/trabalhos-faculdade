package dao;

import connection.ConnectionJDBC;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Carrinho;
import models.CarrinhoProduto;
import models.IngredienteEscolha;
import models.Produto;

public class CarrinhoProdutoDAOImpl implements CarrinhoProdutoDAO {

    @Override
    public boolean insert(CarrinhoProduto carrinhoProduto) {
        String sql = "INSERT INTO public.carrinho_produto(carrinho_id, produto_id, quantidade, ing_escolha_id) VALUES (?, ?, ?, ?)";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoProduto.getCarrinho().getId());
            ps.setInt(2, carrinhoProduto.getProduto().getId());
            ps.setInt(3, carrinhoProduto.getQuantidade());
            ps.setInt(4, carrinhoProduto.getIngEscolha().getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List<CarrinhoProduto> list() {
        List<CarrinhoProduto> list = new LinkedList<>();
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ing_escolha_id FROM public.carrinho_produto";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Carrinho carrinho = null;
            Produto produto = null;
            IngredienteEscolha ingEscolha = null;
            while(rs.next()) {
                carrinho = new CarrinhoDAOImpl().getById(rs.getInt("carrinho_id"));
                produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha));
            }
            
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CarrinhoProduto getById(Integer id) {
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ing_escolha_id FROM public.carrinho_produto WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            CarrinhoProduto cp = null;
            Carrinho carrinho = null;
            Produto produto = null;
            IngredienteEscolha ingEscolha = null;
            if(rs.next()) {
                carrinho = new CarrinhoDAOImpl().getById(rs.getInt("carrinho_id"));
                produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                cp = new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha);
            }
            
            rs.close();
            ps.close();
            return cp;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<CarrinhoProduto> listByCarrinhoId(Integer carrinhoId) {
        List<CarrinhoProduto> list = new LinkedList<>();
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ing_escolha_id FROM public.carrinho_produto WHERE carrinho_id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoId);
            ResultSet rs = ps.executeQuery();

            Carrinho carrinho = null;
            Produto produto = null;
            IngredienteEscolha ingEscolha = null;
            if(rs.next()) {
                carrinho = new CarrinhoDAOImpl().getById(rs.getInt("carrinho_id"));
                produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ing_escolha_id"));
                list.add(new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha));
            }
            
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(CarrinhoProduto carrinhoProduto) {
        String sql = "UPDATE public.carrinho_produto SET carrinho_id = ?, produto_id = ?, quantidade = ?, ing_escolha_id = ? WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoProduto.getCarrinho().getId());
            ps.setInt(2, carrinhoProduto.getProduto().getId());
            ps.setInt(3, carrinhoProduto.getQuantidade());
            ps.setInt(4, carrinhoProduto.getIngEscolha().getId());
            ps.setInt(5, carrinhoProduto.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(CarrinhoProduto carrinhoProduto) {
        String sql = "DELETE FROM public.carrinho_produto WHERE id = ?";
        try {
            Connection c = ConnectionJDBC.getInstance().getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, carrinhoProduto.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
