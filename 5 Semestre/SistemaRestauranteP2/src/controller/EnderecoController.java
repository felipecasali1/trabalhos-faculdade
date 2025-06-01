package controller;

import interfaces.InterfaceController;
import dao.EnderecoDAO;
import dao.EnderecoDAOImpl;
import dto.EnderecoDTO;
import interfaces.InterfaceDTO;
import models.Endereco;

import java.util.LinkedList;
import java.util.List;

public class EnderecoController extends InterfaceController {
    public void insert(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.insert(enderecoDTO.buildEntity());
    }

    public void update(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.update(enderecoDTO.buildEntity());
    }

    public void delete(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.delete(enderecoDTO.buildEntity());
    }

    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        EnderecoDAO dao = new EnderecoDAOImpl();
        for (Endereco e : dao.list()) {
            listDTO.add(EnderecoDTO.buildDTO(e));
        }
        return listDTO;
    }
}
