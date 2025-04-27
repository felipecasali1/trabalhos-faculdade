package models;

import java.time.LocalDateTime;

public class Cupom {
    private int id;
    private float porcentagem;
    private String codigo;
    private LocalDateTime validade;

    public Cupom(int id, float porcentagem, String codigo, LocalDateTime validade) {
        this.id = id;
        this.porcentagem = porcentagem;
        this.codigo = codigo;
        this.validade = validade;
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

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }
}
