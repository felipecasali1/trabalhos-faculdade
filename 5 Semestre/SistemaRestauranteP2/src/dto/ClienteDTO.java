package dto;

import interfaces.InterfaceDTO;
import java.util.List;

import interfaces.InterfaceEntity;
import models.Cliente;

import java.util.stream.Collectors;

public class ClienteDTO extends InterfaceDTO {
    public String nome;
    public List<Integer> telefoneIds;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Cliente) e);
    }

    public static ClienteDTO toDTO(Cliente cliente) {
       ClienteDTO cDTO = new ClienteDTO();
       cDTO.id = cliente.getId() + "";
       cDTO.nome = cliente.getNome();
       cDTO.telefoneIds = cliente.getTelefoneIds();
       return cDTO;
   }

   @Override
    public Cliente buildEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(id));
        cliente.setNome(nome);
        cliente.setTelefoneIds(telefoneIds);
        return cliente;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Nome"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, nome};
    }

    @Override
    public String toString() {
        return nome;
    }
}
