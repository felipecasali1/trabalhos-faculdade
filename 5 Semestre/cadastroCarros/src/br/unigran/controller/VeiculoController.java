package br.unigran.controller;

import br.unigran.connection.ConnectionJBDC;
import br.unigran.model.Veiculo;
import java.util.List;

public class VeiculoController {
    public static void insertVeiculo(String nome, String marca, String cor, Integer km, Float valor) {
        Veiculo veiculo = new Veiculo(nome, marca, cor, km, valor);
        ConnectionJBDC connection = new ConnectionJBDC();
        connection.insertVeiculo(veiculo);
    }
    
    public static List<Veiculo> listVeiculo() {
        ConnectionJBDC connection = new ConnectionJBDC();
        return connection.listVeiculo();
    }
}
