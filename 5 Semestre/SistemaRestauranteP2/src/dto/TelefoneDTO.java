package dto;

import models.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String ddd;
    public ClienteDTO clienteDTO;
    public FuncionarioDTO funcionarioDTO;

    public TelefoneDTO() {
    }

    public TelefoneDTO(String id, String numero, String ddd, ClienteDTO clienteDTO, FuncionarioDTO funcionarioDTO) {
        this.id = id;
        this.numero = numero;
        this.ddd = ddd;
        this.clienteDTO = clienteDTO;
        this.funcionarioDTO = funcionarioDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public FuncionarioDTO getFuncionarioDTO() {
        return funcionarioDTO;
    }

    public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
        this.funcionarioDTO = funcionarioDTO;
    }

    public Telefone builder() {
        Telefone telefone = new Telefone();
        telefone.setId(Integer.parseInt(id));
        telefone.setNumero(numero);
        telefone.setDdd(ddd);
        telefone.setCliente(clienteDTO.builder());
        telefone.setFuncionario(funcionarioDTO.builder());
        return telefone;
    }
}
