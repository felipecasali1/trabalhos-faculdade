package controller;

import models.Produto;
import persistence.Dados;

public class ProdutoController {
    public void salvar(String nome) throws Exception{
        if(nome.isEmpty()){
            throw new Exception("Nome nao pode ser vazio");
        }
        Produto p = new Produto();
        p.setNme(nome);
        Dados.salvar(p);
        
        
        Dados.getDados(Produto.class);
    }
    
}
