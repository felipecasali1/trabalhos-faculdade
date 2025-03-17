package entities;

public abstract class Midia implements Reproduzivel {
    private String nome;
    private Integer duracao;

    public Midia() {
        this.nome = "Nao informado!";
        this.duracao = 0;
    }

    public Midia(String nome, Integer duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String reproduzir() {
        return "Reproduzindo: " + getNome() +
                "\nDuracao: " + getDuracao();
    }
    
    public abstract String listar();
}
