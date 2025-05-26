package controller;

import dao.CarrinhoDAO;
import dao.CarrinhoDAOImpl;
import dto.CarrinhoDTO;
import models.Carrinho;

import java.util.List;

public class CarrinhoController extends InterfaceController {
    public void insert(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.insert(carrinhoDTO.builder());
    }

    public void update(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.update(carrinhoDTO.builder());
    }

    public void delete(CarrinhoDTO carrinhoDTO) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        dao.delete(carrinhoDTO.builder());
    }

    public List<Carrinho> list() {
        //Corrigir para retornar List<CarrinhoDTO>
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return dao.list();
    }
}
