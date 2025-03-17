package controller;

import models.Pessoa;
import persistence.PessoaDAO;

public class PessoaController {   
    public static void salvar(String nome, String cpf, String cidade) {
        Pessoa pessoa = new Pessoa(nome, cpf, cidade);
        PessoaDAO.salvar(pessoa);
    }
}
