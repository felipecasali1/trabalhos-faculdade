package models;

import persistence.CategoriaDao;

public class Categoria {
    private String nome;
    private Integer codigo;

    public Categoria() {
        this.nome = "";
        this.codigo = null;
    }

    public Categoria(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Boolean setCodigo(Integer codigo) {
        if(CategoriaDao.categoriaExiste(codigo) && codigo != null){
            this.codigo = codigo;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nome;
    }
}
