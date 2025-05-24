package dto;

import models.Cliente;

import java.util.stream.Collectors;

public class ClienteDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public List<TelefoneDTO> telefones;

    public ClienteDTO() {
    }

    public ClienteDTO(String id, String nome, List<TelefoneDTO> telefones) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public Cliente builder() {
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(id));
        cliente.setNome(nome);
        cliente.setTelefones(telefones
            .stream()
            .map(TelefoneDTO::builder)
            .collect(Collectors.toList())
        );
        return cliente;
    }
}
