package dto;

import interfaces.InterfaceDTO;
import models.Endereco;

public class EnderecoDTO extends InterfaceDTO {
    public String id;
    public String rua;
    public String cep;
    public BairroDTO bairroDTO;
    public String distancia;

    public static EnderecoDTO buildDTO(Endereco endereco) {
        EnderecoDTO eDTO = new EnderecoDTO();
        eDTO.id = endereco.getId() + "";
        eDTO.rua = endereco.getRua();
        eDTO.cep = endereco.getCep();
        eDTO.bairroDTO = BairroDTO.buildDTO(endereco.getBairro());
        eDTO.distancia = endereco.getDistancia() + "";
        return eDTO;
    }

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
        return new String[]{};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{};
    }
}
