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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        ProdutoDTO produtoDTO = (ProdutoDTO) interfaceDTO;
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.insert(produtoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        ProdutoDTO produtoDTO = (ProdutoDTO) interfaceDTO;
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.update(produtoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        ProdutoDTO produtoDTO = (ProdutoDTO) interfaceDTO;
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.delete(produtoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        ProdutoDAO dao = new ProdutoDAOImpl();
        for (Produto p : dao.list()) {
            listDTO.add(ProdutoDTO.toDTO(p));
        }
        return listDTO;
    }
    
    @Override
    public InterfaceDTO getById(Integer id) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return ProdutoDTO.toDTO(dao.getById(id));
    }
}
