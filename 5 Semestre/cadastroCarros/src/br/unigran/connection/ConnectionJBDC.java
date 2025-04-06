package br.unigran.connection;

import br.unigran.model.Veiculo;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionJBDC {
    private final String url = "jdbc:postgresql://localhost:5432/bancoveiculos";
    private final String user = "postgres";
    private final String password = "1234";
    
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public void insertVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO  public.tb_veiculo(nome, marca, cor, km, valor) VALUES(?,?,?,?,?)";
        try {
            Connection con = createConnection();
            PreparedStatement prepStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            prepStatement.setString(1, veiculo.getNome());
            prepStatement.setString(2, veiculo.getMarca());
            prepStatement.setString(3, veiculo.getCor());
            prepStatement.setInt(4, veiculo.getKm());
            prepStatement.setFloat(5, veiculo.getValor());

            prepStatement.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJBDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Veiculo> listVeiculo() {
        String sql = "SELECT * FROM public.tb_veiculo";
        try {
            List<Veiculo> list = new LinkedList<>();
            Connection con = createConnection();
            PreparedStatement prepStatement = con.prepareStatement(sql);
            ResultSet res = prepStatement.executeQuery();  

            con.close();

            while (res.next()) {
                Integer id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                String cor = res.getString("cor");
                Integer km = res.getInt("km");
                Float valor = res.getFloat("valor");
                list.add(new Veiculo(id, nome, marca, cor, km, valor));   
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJBDC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public void updateVeiculo(Integer id, Veiculo veiculo) {
        String sql = "UPDATE public.tb_veiculo SET nome = ?, marca = ?, cor = ?, km = ?, valor = ? WHERE id = ?";
        try {
            Connection con = createConnection();
            PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setString(1, veiculo.getNome());
            prepStatement.setString(2, veiculo.getMarca());
            prepStatement.setString(3, veiculo.getCor());
            prepStatement.setInt(4, veiculo.getKm());
            prepStatement.setFloat(5, veiculo.getValor());
            prepStatement.setInt(6, id);
            
            prepStatement.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJBDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteVeiculo (Integer id) {
        String sql = "DELETE * FROM public.tb_veiculo WHERE id = ?";
        try {
            Connection con = createConnection();
            PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setInt(1, id);
            
            prepStatement.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJBDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
