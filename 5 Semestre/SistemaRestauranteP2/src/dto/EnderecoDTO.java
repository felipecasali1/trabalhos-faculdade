package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Endereco;

public class EnderecoDTO extends InterfaceDTO {
    public String id;
    public String rua;
    public String cep;
    public BairroDTO bairroDTO;
    public String distancia;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Endereco) e);
    }

    public static EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO eDTO = new EnderecoDTO();
        eDTO.id = endereco.getId() + "";
        eDTO.rua = endereco.getRua();
        eDTO.cep = endereco.getCep();
        eDTO.bairroDTO = BairroDTO.toDTO(endereco.getBairro());
        eDTO.distancia = endereco.getDistancia() + "";
        return eDTO;
    }

    @Override
    public Endereco buildEntity() {
        Endereco endereco = new Endereco();
        endereco.setId(Integer.parseInt(id));
        endereco.setRua(rua);
        endereco.setCep(cep);
        endereco.setBairro(bairroDTO.buildEntity());
        endereco.setDistancia(Float.parseFloat(distancia));
        return endereco;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Rua", "CEP", "Bairro", "Distancia"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, rua, cep, bairroDTO.nome, distancia};
    }
}
