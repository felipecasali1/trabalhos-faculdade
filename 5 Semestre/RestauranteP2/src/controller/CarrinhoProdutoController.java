package controller;

import interfaces.InterfaceController;
import dao.CarrinhoProdutoDAO;
import dao.CarrinhoProdutoDAOImpl;
import dto.CarrinhoProdutoDTO;
import interfaces.InterfaceDTO;
import models.CarrinhoProduto;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoProdutoController extends InterfaceController {
    public void insert(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.insert(carrinhoProdutoDTO.buildEntity());
    }

    public void update(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.update(carrinhoProdutoDTO.buildEntity());
    }

    public void delete(CarrinhoProdutoDTO carrinhoProdutoDTO) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        dao.delete(carrinhoProdutoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        for (CarrinhoProduto cp : dao.list()) {
            listDTO.add(CarrinhoProdutoDTO.buildDTO(cp));
        }
        return listDTO;
    }
}
