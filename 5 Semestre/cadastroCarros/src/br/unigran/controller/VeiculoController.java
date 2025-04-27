package br.unigran.controller;

import br.unigran.connection.ConnectionJDBC;
import br.unigran.model.Veiculo;
import java.util.List;

public class VeiculoController {
    public static void insertVeiculo(String nome, String marca, String cor, Integer km, Float valor) {
        Veiculo veiculo = new Veiculo(nome, marca, cor, km, valor);
        ConnectionJDBC connection = new ConnectionJDBC();
        connection.insertVeiculo(veiculo);
    }
    
    public static List<Veiculo> listVeiculo() {
        ConnectionJDBC connection = new ConnectionJDBC();
        return connection.listVeiculo();
    }
}
