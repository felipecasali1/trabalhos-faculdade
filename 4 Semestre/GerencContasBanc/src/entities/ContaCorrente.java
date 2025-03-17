package entities;

public class ContaCorrente extends ContaBancaria{
    private Float limite;
    private Float taxaAdicional;
    
    //construtores
    public ContaCorrente(){
        super();
        this.limite = 1000F;
        this.taxaAdicional = 8F;
        this.tipo = "Conta Corrente";
    }
    
    public ContaCorrente(Float limite, Float taxaAdicional){
        this.limite = limite;
        this.taxaAdicional = taxaAdicional;
        this.tipo = "Conta Corrente";
    }
    
    //calcular juros
    @Override
    public Float calcularJuros() {
        if(saldo<limite){
            return saldo * ((taxaJuros+taxaAdicional)/100);
        } else{
            return saldo * (taxaJuros/100);
        }
    }
    
    //getters e setters
    public Float getLimite() {
        return limite;
    }

    public void setLimite(Float limite) {
        this.limite = limite;
    }

    public Float getTaxaAdicional() {
        return taxaAdicional;
    }

    public void setTaxaAdicional(Float taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }
    
}
