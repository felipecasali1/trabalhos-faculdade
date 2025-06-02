package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String ddd;
    public ClienteDTO clienteDTO;
    public FuncionarioDTO funcionarioDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Telefone) e);
    }

    public static TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO tDTO = new TelefoneDTO();
        tDTO.id = telefone.getId() + "";
        tDTO.numero = telefone.getNumero();
        tDTO.ddd = telefone.getDdd();
        tDTO.clienteDTO = ClienteDTO.toDTO(telefone.getCliente());
        tDTO.funcionarioDTO = FuncionarioDTO.toDTO(telefone.getFuncionario());
        return tDTO;
    }

    @Override
    public Telefone buildEntity() {
        Telefone telefone = new Telefone();
        telefone.setId(Integer.parseInt(id));
        telefone.setNumero(numero);
        telefone.setDdd(ddd);
        telefone.setCliente(clienteDTO.buildEntity());
        telefone.setFuncionario(funcionarioDTO.buildEntity());
        return telefone;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Numero", "DDD", "Cliente", "Funcionario"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, numero, ddd, clienteDTO.nome, funcionarioDTO.nome};
    }
}
