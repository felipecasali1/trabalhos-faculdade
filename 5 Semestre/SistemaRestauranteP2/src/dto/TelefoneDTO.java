package dto;

import interfaces.InterfaceDTO;
import models.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String ddd;
    public ClienteDTO clienteDTO;
    public FuncionarioDTO funcionarioDTO;

    public static TelefoneDTO buildDTO(Telefone telefone) {
        TelefoneDTO tDTO = new TelefoneDTO();
        tDTO.id = telefone.getId() + "";
        tDTO.numero = telefone.getNumero();
        tDTO.ddd = telefone.getDdd();
        tDTO.clienteDTO = ClienteDTO.buildDTO(telefone.getCliente());
        tDTO.funcionarioDTO = FuncionarioDTO.buildDTO(telefone.getFuncionario());
        return tDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
