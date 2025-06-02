package controller;

import interfaces.InterfaceController;
import dao.TelefoneDAO;
import dao.TelefoneDAOImpl;
import dto.TelefoneDTO;
import interfaces.InterfaceDTO;
import models.Telefone;

import java.util.LinkedList;
import java.util.List;

public class TelefoneController extends InterfaceController {
    public void insert(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.insert(telefoneDTO.buildEntity());
    }

    public void update(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.update(telefoneDTO.buildEntity());
    }

    public void delete(TelefoneDTO telefoneDTO) {
        TelefoneDAO dao = new TelefoneDAOImpl();
        dao.delete(telefoneDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        TelefoneDAO dao = new TelefoneDAOImpl();
        for (Telefone t : dao.list()) {
            listDTO.add(TelefoneDTO.buildDTO(t));
        }
        return listDTO;
    }
}
