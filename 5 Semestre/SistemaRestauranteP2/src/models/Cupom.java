package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Cupom {
    private int id;
    private float porcentagem;
    private String codigo;
    private Timestamp validade;
    private boolean ativo;

    public Cupom(int id, float porcentagem, String codigo, Timestamp validade, boolean ativo) {
        this.id = id;
        this.porcentagem = porcentagem;
        this.codigo = codigo;
        this.validade = validade;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
        this.validade = validade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}