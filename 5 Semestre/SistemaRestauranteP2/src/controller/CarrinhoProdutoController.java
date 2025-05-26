package controller;

import dao.CarrinhoProdutoDAO;
import dao.CarrinhoProdutoDAOImpl;
import dto.CarrinhoProdutoDTO;
import models.CarrinhoProduto;

import java.util.List;

public class CarrinhoProdutoController extends InterfaceController {
    public void insert(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.insert(carrinhoProdutoDTO.builder());
    }

    public void update(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.update(carrinhoProdutoDTO.builder());
    }

    public void delete(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.delete(carrinhoProdutoDTO.builder());
    }

    public List<CarrinhoProduto> list() {
        //Corrigir para retornar List<CarrinhoProdutoDTO>
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        return dao.list();
    }
}
