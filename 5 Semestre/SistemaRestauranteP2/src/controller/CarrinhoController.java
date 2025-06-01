package controller;

import interfaces.InterfaceController;
import dao.CarrinhoDAO;
import dao.CarrinhoDAOImpl;
import dto.CarrinhoDTO;
import interfaces.InterfaceDTO;
import models.Carrinho;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoController extends InterfaceController {
    public void insert(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.insert(carrinhoDTO.buildEntity());
    }

    public void update(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.update(carrinhoDTO.buildEntity());
    }

    public void delete(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.delete(carrinhoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        for (Carrinho c : dao.list()) {
            listDTO.add(CarrinhoDTO.buildDTO(c));
        }
        return listDTO;
    }
}
