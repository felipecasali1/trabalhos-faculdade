package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public String numero;
    public String ddd;
    public Integer clienteId;
    public Integer funcionarioId;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Telefone) e);
    }

    public static TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO tDTO = new TelefoneDTO();
        tDTO.id = telefone.getId() + "";
        tDTO.numero = telefone.getNumero();
        tDTO.ddd = telefone.getDdd();
        if (telefone.getClienteId()!= null) {
            tDTO.clienteId = telefone.getClienteId();
        }
        if (telefone.getFuncionarioId()!= null) {
            tDTO.funcionarioId = telefone.getFuncionarioId();
        }
        return tDTO;
    }

    @Override
    public Telefone buildEntity() {
        Telefone telefone = new Telefone();
        telefone.setId(Integer.parseInt(id));
        telefone.setNumero(numero);
        telefone.setDdd(ddd);
        if (clienteId != null) {
            telefone.setClienteId(clienteId);
        }
        if (funcionarioId != null) {
            telefone.setFuncionarioId(funcionarioId);
        }
        return telefone;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Numero", "DDD", "Cliente Id", "Funcionario Id"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, numero, ddd, clienteId, funcionarioId};
    }
}
