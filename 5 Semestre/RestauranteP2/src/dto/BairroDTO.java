package dto;

import interfaces.InterfaceDTO;
import models.Bairro;

public class BairroDTO extends InterfaceDTO {
    public String id;
    public String nome;

    public static BairroDTO buildDTO(Bairro bairro) {
        BairroDTO bDTO = new BairroDTO();
        bDTO.id = bairro.getId() + "";
        bDTO.nome = bairro.getNome();
        return bDTO;
    }

    public Bairro buildEntity() {
        Bairro b = new Bairro();
        b.setId(Integer.parseInt(id));
        b.setNome(nome);
        return b;
    }

    public String[] getTableHeader() {
        return new String[]{"Nome"};
    }

    public Object[] getTableData() {
        return new Object[]{nome};
    }
}
