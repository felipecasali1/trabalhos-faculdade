package dto;

import interfaces.InterfaceDTO;
import models.Login;

public class LoginDTO extends InterfaceDTO {
    public String id;
    public String usuario;
    public String senha;

    public static LoginDTO buildDTO(Login login) {
        LoginDTO lDTO = new LoginDTO();
        lDTO.id = login.getId() + "";
        lDTO.usuario = login.getUsuario();
        lDTO.senha = login.getSenha();
        return lDTO;
    }

    public Login buildEntity() {
        Login login = new Login();
        login.setId(Integer.parseInt(id));
        login.setUsuario(usuario);
        login.setSenha(senha);
        return login;
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
