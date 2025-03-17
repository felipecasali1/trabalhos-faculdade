package entities;

public class Carro extends Veiculo{
    private String cambio;
    private Integer numeroPortas;

    public Carro() {
        super();
        this.cambio = "Não Informado";
        this.numeroPortas = 0;
    }

    public Carro(String marca, String modelo, Integer anoFabricacao, String numeroIdentificacao, String cambio, Integer numeroPortas, Boolean eletrico) {
        super(marca, modelo, anoFabricacao, numeroIdentificacao, eletrico);
        this.cambio = cambio;
        this.numeroPortas = numeroPortas;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public Integer getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(Integer numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
    
    @Override
    public Float calcularImposto() {
        return getAnoFabricacao()*200F;
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
        return "Carro" +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nCambio: " + getCambio() +
                "\nNumero de portas: " + getNumeroPortas() +
                "\nAno: " + getAnoFabTexto() +
                "\nNumero de Identificacao: " + getNumeroIdentificacao() +
                "\nMotor: " + motorToString() + 
                "\nImposto: R$" + calcularImposto() + 
                "\nDesconto: " + calcularDescontoEletrico() + "%";
    }
}
