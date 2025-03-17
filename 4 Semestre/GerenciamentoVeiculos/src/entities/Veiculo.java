package entities;

public abstract class Veiculo implements VeiculoEletrico{
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String numeroIdentificacao;
    private Boolean eletrico;

    public Veiculo(){
        this.marca = "Não Informado";
        this.marca = "Não Informado";
        this.anoFabricacao = 0;
        this.numeroIdentificacao = "Não Informado";
        this.eletrico = false;
    }
    
    public Veiculo(String marca, String modelo, Integer anoFabricacao, String numeroIdentificacao, Boolean eletrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.numeroIdentificacao = numeroIdentificacao;
        this.eletrico = eletrico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public Boolean getEletrico() {
        return eletrico;
    }

    public void setEletrico(Boolean eletrico) {
        this.eletrico = eletrico;
    }
    
    public String getAnoFabTexto() {
        return getAnoFabricacao()+"";
    }
    
    @Override
    public Float calcularDescontoEletrico() {
        if(eletrico){
            return 10F;
        } else {
            return 0F;
        }
    }
    
    public abstract String motorToString();
    public abstract Float calcularImposto();
    public abstract String listarDados();
}
