package entities;

public class Bicicleta extends Veiculo implements VeiculoEletrico{
    public Bicicleta(){
        super();
    }

    public Bicicleta(String marca, String modelo, Integer anoFabricacao, String numeroIdentificacao, Boolean eletrico) {
        super(marca, modelo, anoFabricacao, numeroIdentificacao, eletrico);
    }
    
    @Override
    public Float calcularImposto() {
        return 0F;
    }
    
    @Override
    public String motorToString() {
        if(getEletrico()){
            return "Eletrica";
        } else {
            return "Humana";
        }
    }
    
    @Override
    public String listarDados() {
        return "Bicicleta" +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAno: " + getAnoFabTexto() +
                "\nNumero de Identificacao: " + getNumeroIdentificacao() +
                "\nTipo de propulsao: " + motorToString() +
                "\nImposto: R$" + calcularImposto() + 
                "\nDesconto: " + calcularDescontoEletrico() + "%";
    }
}
