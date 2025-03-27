package controller;

import models.Pessoa;
import persistence.PessoaDAO;

public class PessoaController {   
    public static boolean salvar(String nome, String cpf, String cidade) {
        Pessoa pessoa = new Pessoa(nome, cpf, cidade);
        PessoaDAO.salvar(pessoa);
        return PessoaDAO.verificar(pessoa);
    }
}
