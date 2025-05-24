package dto;

import models.Cupom;

import java.sql.Timestamp;

public class CupomDTO extends InterfaceDTO {
    public String id;
    public String porcentagem;
    public String codigo;
    public String validade;
    public String ativo;

    public CupomDTO() {
    }

    public CupomDTO(String id, String porcentagem, String codigo, String validade, String ativo) {
        this.id = id;
        this.porcentagem = porcentagem;
        this.codigo = codigo;
        this.validade = validade;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Cupom builder() {
        Cupom cupom = new Cupom();
        cupom.setId(Integer.parseInt(id));
        cupom.setPorcentagem(Float.parseFloat(porcentagem));
        cupom.setCodigo(codigo);
        cupom.setValidade(Timestamp.valueOf(validade));
        cupom.setAtivo(Boolean.parseBoolean(ativo));
        return cupom;
    }
}
