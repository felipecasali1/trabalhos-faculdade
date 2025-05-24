package dto;

import models.Bairro;

public class BairroDTO extends InterfaceDTO {
    public String id;
    public String nome;

    public BairroDTO() {
    }

    public BairroDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Bairro builder() {
        Bairro bairro = new Bairro();
        bairro.setId(Integer.parseInt(id));
        bairro.setNome(nome);
        return bairro;
    }
}
