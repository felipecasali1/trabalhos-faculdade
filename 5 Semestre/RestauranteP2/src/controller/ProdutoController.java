package controller;

import interfaces.InterfaceController;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import dto.ProdutoDTO;
import interfaces.InterfaceDTO;
import models.Produto;

import java.util.LinkedList;
import java.util.List;

public class ProdutoController extends InterfaceController {
    public void insert(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.insert(produtoDTO.buildEntity());
    }

    public void update(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.update(produtoDTO.buildEntity());
    }

    public void delete(ProdutoDTO produtoDTO) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        dao.delete(produtoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ProdutoDAO dao = new ProdutoDAOImpl();
        for (Produto p : dao.list()) {
            listDTO.add(ProdutoDTO.buildDTO(p));
        }
        return listDTO;
    }
}
