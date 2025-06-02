package dto;

import interfaces.InterfaceDTO;
import models.Delivery;

public class DeliveryDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String complemento;
    public EnderecoDTO enderecoDTO;

    public static DeliveryDTO buildDTO(Delivery delivery) {
        DeliveryDTO dDTO = new DeliveryDTO();
        dDTO.id = delivery.getId() + "";
        dDTO.numero = delivery.getNumero();
        dDTO.complemento = delivery.getComplemento();
        dDTO.enderecoDTO = EnderecoDTO.buildDTO(delivery.getEndereco());
        return dDTO;
    }

    public Delivery buildEntity() {
        Delivery delivery = new Delivery();
        delivery.setId(Integer.parseInt(id));
        delivery.setNumero(numero);
        delivery.setComplemento(complemento);
        delivery.setEndereco(enderecoDTO.buildEntity());
        return delivery;
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
