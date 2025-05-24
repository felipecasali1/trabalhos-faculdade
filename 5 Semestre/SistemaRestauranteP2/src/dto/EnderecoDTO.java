package dto;

import models.Endereco;

public class EnderecoDTO extends InterfaceDTO {
    public String id;
    public String rua;
    public String cep;
    public BairroDTO bairro;
    public String distancia;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String id, String rua, String cep, BairroDTO bairro, String distancia) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.distancia = distancia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public BairroDTO getBairro() {
        return bairro;
    }

    public void setBairro(BairroDTO bairro) {
        this.bairro = bairro;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public Endereco builder() {
        Endereco endereco = new Endereco();
        endereco.setId(Integer.parseInt(id));
        endereco.setRua(rua);
        endereco.setCep(cep);
        endereco.setBairro(bairro.builder());
        endereco.setDistancia(Float.parseFloat(distancia));
        return endereco;
    }
}
