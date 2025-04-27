package models;

import java.util.List;

public class IngredienteEscolha {
    private int id;
    private List<IngredienteAdicionar> ingAdd;
    private List<IngredienteRemover> ingRemover;

    public IngredienteEscolha(int id, List<IngredienteAdicionar> ingAdd, List<IngredienteRemover> ingRemover) {
        this.id = id;
        this.ingAdd = ingAdd;
        this.ingRemover = ingRemover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<IngredienteAdicionar> getIngAdd() {
        return ingAdd;
    }

    public void setIngAdd(List<IngredienteAdicionar> ingAdd) {
        this.ingAdd = ingAdd;
    }

    public List<IngredienteRemover> getIngRemover() {
        return ingRemover;
    }

    public void setIngRemover(List<IngredienteRemover> ingRemover) {
        this.ingRemover = ingRemover;
    }
}