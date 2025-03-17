package app;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import entities.Bicicleta;
import entities.Carro;
import entities.Veiculo;
import entities.Moto;
import entities.VeiculoEletrico;

public class Main {
    public static void main(String[] args) {
        List <Veiculo>veiculos = new LinkedList();
        Boolean run = true;
        do {
            Integer option = Integer.valueOf(JOptionPane.showInputDialog(null, "\nMENU"
                    + "\n 1 - Cadastrar Carro"
                    + "\n 2 - Cadastrar Moto"
                    + "\n 3 - Cadastrar Bicicleta"
                    + "\n 4 - Listar"
                    + "\n 0 - Sair"));
            switch(option){
                case 0:
                    run = false;
                    JOptionPane.showMessageDialog(null, "Finalizando...");
                    break;
                case 1:
                    Veiculo carro = new Carro();
                    Boolean erro = false;
                    carro.setModelo(JOptionPane.showInputDialog(null, "Informe o modelo: "));
                    carro.setMarca(JOptionPane.showInputDialog(null, "Informe a marca: "));
                    carro.setNumeroIdentificacao(JOptionPane.showInputDialog(null, "Informe o numero de identificacao: "));
                    carro.setAnoFabricacao(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe o ano de fabricacao: ")));
                    ((Carro)carro).setCambio(JOptionPane.showInputDialog(null, "Informe o cambio (automatico ou manual): "));
                    ((Carro)carro).setNumeroPortas(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe o numero de portas: ")));
                    Integer isEletrico = JOptionPane.showConfirmDialog(null, "O carro é eletrico?", "Selecione uma opcao", JOptionPane.YES_NO_OPTION);
                    if(isEletrico == JOptionPane.YES_OPTION){
                        carro.setEletrico(true);
                    } else if (isEletrico == JOptionPane.NO_OPTION){
                        carro.setEletrico(false);
                    } else {
                        erro = true;
                    }
                    if(erro){
                        JOptionPane.showMessageDialog(null, "Um erro aconteceu! Tente novamente");
                    } else {
                        veiculos.add(carro);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
                    }
                    break;
                case 2:
                    Veiculo moto = new Moto();
                    erro = false;
                    moto.setModelo(JOptionPane.showInputDialog(null, "Informe o modelo: "));
                    moto.setMarca(JOptionPane.showInputDialog(null, "Informe a marca: "));
                    moto.setNumeroIdentificacao(JOptionPane.showInputDialog(null, "Informe o numero de identificacao: "));
                    moto.setAnoFabricacao(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe o ano de fabricacao: ")));
                    ((Moto)moto).setCilindrada(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe a cilindrada: ")));
                    isEletrico = JOptionPane.showConfirmDialog(null, "A moto é eletrica?", "Selecione uma opcao", JOptionPane.YES_NO_OPTION);
                    if(isEletrico == JOptionPane.YES_OPTION){
                        moto.setEletrico(true);
                    } else if (isEletrico == JOptionPane.NO_OPTION){
                        moto.setEletrico(false);
                    } else {
                        erro = true;
                    }
                    if(erro){
                        JOptionPane.showMessageDialog(null, "Um erro aconteceu! Tente novamente");
                    } else {
                        veiculos.add(moto);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
                    }
                    break;
                case 3:
                    Veiculo bicicleta = new Bicicleta();
                    erro = false;
                    bicicleta.setModelo(JOptionPane.showInputDialog(null, "Informe o modelo: "));
                    bicicleta.setMarca(JOptionPane.showInputDialog(null, "Informe a marca: "));
                    bicicleta.setNumeroIdentificacao(JOptionPane.showInputDialog(null, "Informe o numero de identificacao: "));
                    bicicleta.setAnoFabricacao(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe o ano de fabricacao: ")));
                    isEletrico = JOptionPane.showConfirmDialog(null, "A bicicleta é eletrica?", "Selecione uma opcao", JOptionPane.YES_NO_OPTION);
                    if(isEletrico == JOptionPane.YES_OPTION){
                        bicicleta.setEletrico(true);
                    } else if (isEletrico == JOptionPane.NO_OPTION){
                        bicicleta.setEletrico(false);
                    } else {
                        erro = true;
                    }
                    if(erro){
                        JOptionPane.showMessageDialog(null, "Um erro aconteceu! Tente novamente");
                    } else {
                        veiculos.add(bicicleta);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
                    }
                    break;
                case 4:
                    if(veiculos.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum cadastro encontrado!");
                    } else {
                        for(Veiculo veiculo : veiculos){
                            JOptionPane.showMessageDialog(null, veiculo.listarDados());
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida!");
                    break;
            }
        } while(run);
    }
}
