package dto;

import interfaces.InterfaceDTO;
import interfaces.InterfaceEntity;
import models.Bairro;

public class BairroDTO extends InterfaceDTO {
    public String nome;

    @Override
    public InterfaceDTO buildDTO(InterfaceEntity e) {
        return (InterfaceDTO) toDTO((Bairro) e);
    }

    public static BairroDTO toDTO(Bairro bairro) {
        BairroDTO bDTO = new BairroDTO();
        bDTO.id = bairro.getId() + "";
        bDTO.nome = bairro.getNome();
        return bDTO;
    }

    @Override
    public Bairro buildEntity() {
        Bairro b = new Bairro();
        b.setId(Integer.parseInt(id));
        b.setNome(nome);
        return b;
    }

    @Override
    public String[] getTableHeader() {
        return new String[]{"Id", "Nome"};
    }

    @Override
    public Object[] getTableData() {
        return new Object[]{id, nome};
    }

    @Override
    public String toString() {
        return nome;
    }
}
