package controller;

import dao.TelefoneDAO;
import dao.TelefoneDAOImpl;
import dto.TelefoneDTO;
import models.Telefone;

import java.util.List;

public class TelefoneController extends InterfaceController {
    public void insert(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.insert(telefoneDTO.builder());
    }

    public void update(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.update(telefoneDTO.builder());
    }

    public void delete(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.delete(telefoneDTO.builder());
    }

    public List<Telefone> list() {
        TelefoneDAO dao = new TelefoneDAOImpl();
        return dao.list();
    }
}
