package entities;

public class Funcionario {
    private String nome;
    private String setor;
    private Double salarioBruto;
    private String dataAdmissao;
    private String dataDemissao;
    
    public Funcionario() {
        this.nome = "Não Informado!";
        this.setor = "Não Informado!";
        this.salarioBruto = 0D;
        this.dataAdmissao = "Não Informado!";
        this.dataDemissao = "Não Informado!";
    }

    public Funcionario(String nome, String setor, Double salarioBruto, String dataAdmissao, String dataDemissao) {
        this.nome = nome;
        this.setor = setor;
        this.salarioBruto = salarioBruto;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public String getSituacao() {
        if (dataDemissao == null || dataDemissao.isEmpty() && !dataAdmissao.isEmpty()) {
            return "Ativo";
        } 
        return "Demitido";
    }

    public Double calcularSalarioLiquido() {
        if (salarioBruto <= 1900.00) {return salarioBruto;}
        else if (salarioBruto <= 2800.00) {return salarioBruto * 0.925;}
        else if (salarioBruto <= 3750.00) {return salarioBruto * 0.85;}
        else if (salarioBruto < 4660.00) {return salarioBruto * 0.775;}
        else {return salarioBruto * 0.725;}
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
}