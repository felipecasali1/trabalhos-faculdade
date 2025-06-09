package models;

import interfaces.InterfaceEntity;

public class Telefone extends InterfaceEntity {
    private int id;
    private String numero;
    private String ddd;
    private Integer clienteId;
    private Integer funcionarioId;

    public Telefone() {
    }

    public Telefone(int id, String numero, String ddd, Integer clienteId, Integer funcionarioId) {
        this.id = id;
        this.numero = numero;
        this.ddd = ddd;
        this.clienteId = clienteId;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}
