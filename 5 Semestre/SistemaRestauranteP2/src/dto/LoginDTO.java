package dto;

import models.Login;

public class LoginDTO extends InterfaceDTO {
    public String id;
    public String usuario;
    public String senha;

    public LoginDTO() {
    }

    public LoginDTO(String id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login builder() {
        Login login = new Login();
        login.setId(Integer.parseInt(id));
        login.setUsuario(usuario);
        login.setSenha(senha);
        return login;
    }
}
