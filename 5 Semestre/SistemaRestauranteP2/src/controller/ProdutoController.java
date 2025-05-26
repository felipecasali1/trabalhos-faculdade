package controller;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import dto.ProdutoDTO;
import models.Produto;

import java.util.List;

public class ProdutoController extends InterfaceController {
    public void insert(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.insert(produtoDTO.builder());
    }

    public void update(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.update(produtoDTO.builder());
    }

    public void delete(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.delete(produtoDTO.builder());
    }

    public List<Produto> list() {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.list();
    }
}
