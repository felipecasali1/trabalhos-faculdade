package dto;

import interfaces.InterfaceDTO;
import models.Cupom;

import java.sql.Timestamp;
import java.util.stream.Collectors;

public class CupomDTO extends InterfaceDTO {
    public String id;
    public String porcentagem;
    public String codigo;
    public String validade;
    public String ativo;

    public static CupomDTO buildDTO(Cupom cupom) {
        CupomDTO cDTO = new CupomDTO();
        cDTO.id = cupom.getId() + "";
        cDTO.porcentagem = cupom.getPorcentagem() + "";
        cDTO.codigo = cupom.getCodigo();
        cDTO.validade = cupom.getValidade() + "";
        cDTO.ativo = cupom.isAtivo() + "";
        return cDTO;
    }

    public Cupom buildEntity() {
        Cupom cupom = new Cupom();
        cupom.setId(Integer.parseInt(id));
        cupom.setPorcentagem(Float.parseFloat(porcentagem));
        cupom.setCodigo(codigo);
        cupom.setValidade(Timestamp.valueOf(validade));
        cupom.setAtivo(Boolean.parseBoolean(ativo));
        return cupom;
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
