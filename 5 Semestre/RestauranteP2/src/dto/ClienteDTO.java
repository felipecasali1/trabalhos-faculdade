package dto;

import interfaces.InterfaceDTO;
import java.util.List;
import models.Cliente;

import java.util.stream.Collectors;

public class ClienteDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public List<TelefoneDTO> telefones;

   public static ClienteDTO buildDTO(Cliente cliente) {
       ClienteDTO cDTO = new ClienteDTO();
       cDTO.id = cliente.getId() + "";
       cDTO.nome = cliente.getNome();
       cDTO.telefones = cliente.getTelefones()
           .stream()
           .map(TelefoneDTO::buildDTO)
           .collect(Collectors.toList());
       return cDTO;
   }

    public Cliente buildEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(id));
        cliente.setNome(nome);
        cliente.setTelefones(telefones
            .stream()
            .map(TelefoneDTO::buildEntity)
            .collect(Collectors.toList())
        );
        return cliente;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
