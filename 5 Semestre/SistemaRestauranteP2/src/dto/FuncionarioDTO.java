package dto;

import interfaces.InterfaceDTO;
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

   public static FuncionarioDTO buildDTO(Funcionario funcionario) {
       FuncionarioDTO fDTO = new FuncionarioDTO();
       fDTO.id = funcionario.getId() + "";
       fDTO.nome = funcionario.getNome();
       fDTO.cpf = funcionario.getCpf();
       fDTO.rg = funcionario.getRg();
       fDTO.loginDTO = LoginDTO.buildDTO(funcionario.getLogin());
       fDTO.telefones = funcionario.getTelefones()
               .stream()
               .map(TelefoneDTO::buildDTO)
               .collect(Collectors.toList());
       return fDTO;
   }

    public Funcionario buildEntity() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(Integer.parseInt(id));
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setRg(rg);
        funcionario.setLogin(loginDTO.buildEntity());
        funcionario.setTelefones(telefones
            .stream()
            .map(TelefoneDTO::buildEntity)
            .collect(Collectors.toList())
        );
        return funcionario;
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
