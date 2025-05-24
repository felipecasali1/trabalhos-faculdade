package dto;

import models.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public String cpf;
    public String rg;
    public LoginDTO loginDTO;
    public List<TelefoneDTO> telefones;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(String id, String nome, String cpf, String rg, LoginDTO loginDTO, List<TelefoneDTO> telefones) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.loginDTO = loginDTO;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public Funcionario builder() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(Integer.parseInt(id));
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setRg(rg);
        funcionario.setLogin(loginDTO.builder());
        funcionario.setTelefones(telefones
            .stream()
            .map(TelefoneDTO::builder)
            .collect(Collectors.toList())
        );
        return funcionario;
    }
}
