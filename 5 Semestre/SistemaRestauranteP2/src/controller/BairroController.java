package controller;

import dao.BairroDAO;
import dao.BairroDAOImpl;
import dto.BairroDTO;
import models.Bairro;

import java.sql.*;
import java.util.List;

public class BairroController extends InterfaceController {
    public void insert(BairroDTO bairroDTO) throws SQLException {
        BairroDAO dao = new BairroDAOImpl();
        dao.insert(bairroDTO.builder());
    }

    public void update(BairroDTO bairroDTO) throws SQLException{
        BairroDAO dao = new BairroDAOImpl();
        dao.update(bairroDTO.builder());
    }

    public void delete(BairroDTO bairroDTO){
        BairroDAO dao = new BairroDAOImpl();
        dao.delete(bairroDTO.builder());
    }

    public List<Bairro> list(){
        BairroDAO dao = new BairroDAOImpl();
        return dao.list();
    }
}
