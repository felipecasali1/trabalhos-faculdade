package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Login;

public class LoginDTO extends InterfaceDTO {
    public String usuario;
    public String senha;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Login) e);
    }

    public static LoginDTO toDTO(Login login) {
        LoginDTO lDTO = new LoginDTO();
        lDTO.id = login.getId() + "";
        lDTO.usuario = login.getUsuario();
        lDTO.senha = login.getSenha();
        return lDTO;
    }

    @Override
    public Login buildEntity() {
        Login login = new Login();
        login.setId(Integer.parseInt(id));
        login.setUsuario(usuario);
        login.setSenha(senha);
        return login;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Usuario", "Senha"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, usuario, senha};
    }

    @Override
    public String toString() {
        return usuario;
    }
    
}
