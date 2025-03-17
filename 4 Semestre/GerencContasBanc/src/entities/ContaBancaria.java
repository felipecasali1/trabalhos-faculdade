package entities;

public class ContaBancaria {
    protected Float saldo;
    protected Float taxaJuros;
    protected String tipo;
    
    //construtores
    public ContaBancaria(){
        this.saldo = 0F;
        this.taxaJuros = 6F;
        this.tipo = "Conta Bancaria";
    }
    
    public ContaBancaria(Float saldo, Float taxaJuros){
        this.saldo = saldo;
        this.taxaJuros = taxaJuros;
        this.tipo = "Conta Bancaria";
    }
    
    //calcular juros
    public Float calcularJuros(){
        return saldo*(taxaJuros/100);
    }
    
    //getters e setters
    public Float getSaldo() {
        return saldo;
    }

    public Float getTaxaJuros() {
        return taxaJuros;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public void setTaxaJuros(Float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public String getTipo() {
        return tipo;
    }
}
