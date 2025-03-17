package entities;

public class Roupas extends Produtos implements Interface {
    private String marca;
    private String tamanho;
    
    public Roupas(){
        super();
        this.marca = "Não Informado";
        this.tamanho = "Não Informado";
    }
    
    public Roupas(String nome, Float preco, String marca, String tamanho){
        super(nome, preco);
        this.marca = marca;
        this.tamanho = tamanho;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    //sobrescrevendo os metodos abstratos da interface
    @Override
    public Float calcDesconto() {
        return (getPreco() * 0.85F);
    }
    
    @Override
    public String exibDescricao() {
        return "\nRoupa: " + getNome() + 
                "\n Marca: " + getMarca() + 
                "\n Tamanho: " + getTamanho()+ 
                "\n Preco: R$" + getPreco();
    }
    
    //sobrescrevendo os metodos abstratos da classe produtos
    @Override
    public String exibInformacoes() {
        return exibDescricao() + "\n Preco com desconto: R$" + calcDesconto();
    }
}
