package controller;

import dao.EnderecoDAO;
import dao.EnderecoDAOImpl;
import dto.EnderecoDTO;
import models.Endereco;

import java.util.List;

public class EnderecoController extends InterfaceController {
    public void insert(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.insert(enderecoDTO.builder());
    }

    public void update(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.update(enderecoDTO.builder());
    }

    public void delete(EnderecoDTO enderecoDTO) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        dao.delete(enderecoDTO.builder());
    }

    public List<Endereco> list() {
        //Corrigir para retornar List<EnderecoDTO>
        EnderecoDAO dao = new EnderecoDAOImpl();
        return dao.list();
    }
}
