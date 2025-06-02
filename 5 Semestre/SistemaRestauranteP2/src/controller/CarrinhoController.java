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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        CarrinhoDTO carrinhoDTO = (CarrinhoDTO) interfaceDTO;
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return dao.insert(carrinhoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        CarrinhoDTO carrinhoDTO = (CarrinhoDTO) interfaceDTO;
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return dao.update(carrinhoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        CarrinhoDTO carrinhoDTO = (CarrinhoDTO) interfaceDTO;
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return dao.delete(carrinhoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        for (Carrinho c : dao.list()) {
            listDTO.add(CarrinhoDTO.toDTO(c));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        CarrinhoDAO dao = new CarrinhoDAOImpl();
        return CarrinhoDTO.toDTO(dao.getById(id));
    }
}
