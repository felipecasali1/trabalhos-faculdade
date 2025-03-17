package entities;

public class Moto extends Veiculo{
    private Integer cilindrada;

    public Moto() {
        super();
        this.cilindrada = 0;
    }

    public Moto(Integer cilindrada, String marca, String modelo, Integer anoFabricacao, String numeroIdentificacao, Boolean eletrico) {
        super(marca, modelo, anoFabricacao, numeroIdentificacao, eletrico);
        this.cilindrada = cilindrada;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    @Override
    public Float calcularImposto() {
        return getAnoFabricacao()*150F;
    }
    
    @Override
    public String motorToString() {
        if(getEletrico()){
            return "Eletrico";
        } else {
            return "Combustao";
        }
    }

    @Override
    public String listarDados() {
        return "Moto" +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nCilindrada: " + getCilindrada() +
                "\nAno: " + getAnoFabTexto() +
                "\nNumero de Identificacao: " + getNumeroIdentificacao() +
                "\nMotor: " + motorToString() + 
                "\nImposto: R$" + calcularImposto() + 
                "\nDesconto: " + calcularDescontoEletrico() + "%";
    }
}

