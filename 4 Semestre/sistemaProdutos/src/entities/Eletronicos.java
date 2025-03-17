package entities;

public class Eletronicos extends Produtos implements Interface {
    private String marca;
    private Integer garantia;

    public Eletronicos(){
        super();
        this.marca = "Não Informado";
        this.garantia = 12;
    }
    
    public Eletronicos(String nome, Float preco, String marca, Integer garantia){
        super(nome, preco);
        this.marca = marca;
        this.garantia = garantia;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }

    //sobrescrevendo os metodos abstratos da interface
    @Override
    public Float calcDesconto() {
        return (getPreco() * 0.9F);
    }
    
    @Override
    public String exibDescricao() {
        return "\nEletronico: " + getNome() + 
                "\n Marca: " + getMarca() + 
                "\n Garantia: " + getGarantia() + 
                "\n Preco: R$" + getPreco();
    }
    
    //sobrescrevendo os metodos abstratos da classe produtos
    @Override
    public String exibInformacoes() {
        return exibDescricao() + "\n Preco com desconto: R$" + calcDesconto();
    }
}
