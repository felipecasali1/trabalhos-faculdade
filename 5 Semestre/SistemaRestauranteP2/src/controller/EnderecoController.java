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
    @Override
    public boolean insert(InterfaceDTO interfaceDTO) {
        EnderecoDTO enderecoDTO = (EnderecoDTO) interfaceDTO;
        EnderecoDAO dao = new EnderecoDAOImpl();
        return dao.insert(enderecoDTO.buildEntity());
    }

    @Override
    public boolean update(InterfaceDTO interfaceDTO) {
        EnderecoDTO enderecoDTO = (EnderecoDTO) interfaceDTO;
        EnderecoDAO dao = new EnderecoDAOImpl();
        return dao.update(enderecoDTO.buildEntity());
    }

    @Override
    public boolean delete(InterfaceDTO interfaceDTO) {
        EnderecoDTO enderecoDTO = (EnderecoDTO) interfaceDTO;
        EnderecoDAO dao = new EnderecoDAOImpl();
        return dao.delete(enderecoDTO.buildEntity());
    }

    @Override
    public List<InterfaceDTO> list() {
        List<InterfaceDTO> listDTO = new LinkedList<>();
        EnderecoDAO dao = new EnderecoDAOImpl();
        for (Endereco e : dao.list()) {
            listDTO.add(EnderecoDTO.toDTO(e));
        }
        return listDTO;
    }

    @Override
    public InterfaceDTO getById(Integer id) {
        EnderecoDAO dao = new EnderecoDAOImpl();
        return EnderecoDTO.toDTO(dao.getById(id));
    }
}
