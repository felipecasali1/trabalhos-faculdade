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
    public void insert(CarrinhoProduto carrinhoProduto) {
        String sql = "INSERT INTO public.carrinho_produto(carrinho_id, produto_id, quantidade, ingrediente_escolha_id) VALUES (?, ?, ?, ?)";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoProduto.getCarrinho().getId());
            ps.setInt(2, carrinhoProduto.getProduto().getId());
            ps.setInt(3, carrinhoProduto.getQuantidade());
            ps.setInt(4, carrinhoProduto.getIngEscolha().getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CarrinhoProduto> list() {
        List<CarrinhoProduto> list = new LinkedList<>();
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ingrediente_escolha_id FROM public.carrinho_produto";
        try {    
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Carrinho carrinho = new CarrinhoDAOImpl().getById(rs.getInt("id"));
                Produto produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                IngredienteEscolha ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ingrediente_escolha_id"));
                list.add(new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CarrinhoProduto getById(Integer id) {
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ingrediente_escolha_id FROM public.carrinho_produto WHERE id = ?";
        try {    
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            CarrinhoProduto cp = null;
            if(rs.next()) {
                Carrinho carrinho = new CarrinhoDAOImpl().getById(rs.getInt("id"));
                Produto produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                IngredienteEscolha ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ingrediente_escolha_id"));
                cp = new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha);
            }
            
            rs.close();
            ps.close();
            c.close();
            return cp;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<CarrinhoProduto> listByCarrinhoId(Integer carrinhoId) {
        List<CarrinhoProduto> list = new LinkedList<>();
        String sql = "SELECT id, carrinho_id, produto_id, quantidade, ingrediente_escolha_id FROM public.carrinho_produto WHERE carrinho_id = ?";
        try {    
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoId);
            ResultSet rs = ps.executeQuery();
            
            CarrinhoProduto cp = null;
            if(rs.next()) {
                Carrinho carrinho = new CarrinhoDAOImpl().getById(rs.getInt("id"));
                Produto produto = new ProdutoDAOImpl().getById(rs.getInt("produto_id"));
                IngredienteEscolha ingEscolha = new IngredienteEscolhaDAOImpl().getById(rs.getInt("ingrediente_escolha_id"));
                list.add(new CarrinhoProduto(rs.getInt("id"), carrinho, produto, rs.getInt("quantidade"), ingEscolha));
            }
            
            rs.close();
            ps.close();
            c.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(CarrinhoProduto carrinhoProduto) {
        String sql = "UPDATE public.carrinho_produto SET carrinho_id = ?, produto_id = ?, quantidade = ?, ingrediente_escolha_id = ? WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, carrinhoProduto.getCarrinho().getId());
            ps.setInt(2, carrinhoProduto.getProduto().getId());
            ps.setInt(3, carrinhoProduto.getQuantidade());
            ps.setInt(4, carrinhoProduto.getIngEscolha().getId());
            ps.setInt(5, carrinhoProduto.getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(CarrinhoProduto carrinhoProduto) {
        String sql = "DELETE FROM public.carrinho_produto WHERE id = ?";
        try {
            ConnectionJDBC jdbc = new ConnectionJDBC();
            Connection c = jdbc.createConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setInt(1, carrinhoProduto.getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();          
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoProdutoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
