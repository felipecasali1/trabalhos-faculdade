package dto;

import models.Delivery;

public class DeliveryDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String complemento;
    public EnderecoDTO endereco;

    public DeliveryDTO() {
    }

    public DeliveryDTO(String id, String numero, String complemento, EnderecoDTO endereco) {
        this.id = id;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Delivery builder() {
        Delivery delivery = new Delivery();
        delivery.setId(Integer.parseInt(id));
        delivery.setNumero(numero);
        delivery.setComplemento(complemento);
        delivery.setEndereco(endereco.builder());
        return delivery;
    }
}
