package entities;

public class ContaPoupanca extends ContaBancaria {
    private Float valorMin;
    
    //construtores
    public ContaPoupanca(){
        super();
        this.valorMin = 200F;
        this.tipo = "Conta Poupanca";
    }
    
    public ContaPoupanca(Float valorMin){
        super();
        this.valorMin = valorMin;
        this.tipo = "Conta Poupanca";
    }

    //calcular juros
    public Float calcularJuros(){
        if(saldo>valorMin){
            return saldo*(taxaJuros/100);
        } else{
            return 0F;
        }
    }
    
    //getters e setters
    public Float getValorMin() {
        return valorMin;
    }

    public void setValorMin(Float valorMin) {
        this.valorMin = valorMin;
    }
}
