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
    public CarrinhoProdutoController() {
        this.interfaceDTO = new CarrinhoProdutoDTO();
    }
    
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        CarrinhoProdutoDTO carrinhoProdutoDTO = (CarrinhoProdutoDTO) interfaceDTO;
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        return dao.insert(carrinhoProdutoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        CarrinhoProdutoDTO carrinhoProdutoDTO = (CarrinhoProdutoDTO) interfaceDTO;
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        return dao.update(carrinhoProdutoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        CarrinhoProdutoDTO carrinhoProdutoDTO = (CarrinhoProdutoDTO) interfaceDTO;
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        return dao.delete(carrinhoProdutoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        for (CarrinhoProduto cp : dao.list()) {
            listDTO.add(CarrinhoProdutoDTO.toDTO(cp));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        CarrinhoProdutoDAO dao = new CarrinhoProdutoDAOImpl();
        return CarrinhoProdutoDTO.toDTO(dao.getById(id));
    }
}
