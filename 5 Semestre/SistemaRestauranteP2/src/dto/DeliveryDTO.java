package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Delivery;

public class DeliveryDTO extends InterfaceDTO {
    public String id;
    public String numero;
    public String complemento;
    public EnderecoDTO enderecoDTO;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Delivery) e);
    }

    public static DeliveryDTO toDTO(Delivery delivery) {
        DeliveryDTO dDTO = new DeliveryDTO();
        dDTO.id = delivery.getId() + "";
        dDTO.numero = delivery.getNumero();
        dDTO.complemento = delivery.getComplemento();
        dDTO.enderecoDTO = EnderecoDTO.toDTO(delivery.getEndereco());
        return dDTO;
    }

    @Override
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
        return new String[]{"Id", "Numero", "Complemento", "Rua"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, numero, complemento, enderecoDTO.rua};
    }
}
