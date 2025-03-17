package entities;

public class ContaInvestimento extends ContaBancaria{
    private Float taxaJurosVar;
    private Float valorInvestido;
    
    //construtores
    public ContaInvestimento(){
        super();
        this.taxaJurosVar = 6.5F;
        this.valorInvestido = 0F;
        this.tipo = "Conta Investimento";
    }
    
    public ContaInvestimento(Float taxaJurosVar, Float valorInvestido){
        this.taxaJurosVar = taxaJurosVar;
        this.valorInvestido = valorInvestido;
        this.tipo = "Conta Investimento";
    }
    
    //calcular juros
    @Override
    public Float calcularJuros(){
        return (taxaJurosVar/100)*valorInvestido;
    }
    
    //getters e setters
    public Float getTaxaJurosVar() {
        return taxaJurosVar;
    }

    public void setTaxaJurosVar(Float taxaJurosVar) {
        this.taxaJurosVar = taxaJurosVar;
    }

    public Float getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Float valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
    
}
