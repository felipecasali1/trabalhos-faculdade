package entities;

public abstract class Produtos {
    private String nome;
    private Float preco;
    
    public Produtos(){
        this.nome = "Não cadastrado";
        this.preco = 0F;
    }
    
    public Produtos(String nome, Float preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    public abstract String exibInformacoes();
}
