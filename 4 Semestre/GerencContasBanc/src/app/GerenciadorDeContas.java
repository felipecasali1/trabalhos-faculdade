package app;
import java.util.Scanner;
import entities.ContaBancaria;
import entities.ContaCorrente;
import entities.ContaInvestimento;
import entities.ContaPoupanca;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeContas {
    public static void main(String[] args) {
        Integer option = 0;
        Scanner ler = new Scanner(System.in);
        List <ContaBancaria>contas = new LinkedList<ContaBancaria>();
        do{
            System.out.println("\nMENU");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupanca");
            System.out.println("3 - Conta Investimento");
            System.out.println("4 - Listar os Juros daas Contas");
            System.out.println("0 - Sair");
            option = ler.nextInt();
            ler.nextLine();
            
            switch(option){
                case 0:
                    System.out.println("Finalizando...");
                    break;
                case 1:
                    System.out.println("\nCriar Conta Corrente");
                    ContaBancaria contaC = new ContaCorrente();
                    System.out.println("Informe o saldo: ");
                    contaC.setSaldo(ler.nextFloat());
                    ler.nextLine();
                    contas.add(contaC);
                    System.out.println("Cadastro realizado!");
                    break;
                case 2:
                    System.out.println("\nCriar Conta Poupanca");
                    ContaPoupanca contaP = new ContaPoupanca();
                    System.out.println("Informe o saldo: ");
                    contaP.setSaldo(ler.nextFloat());
                    ler.nextLine();
                    contas.add(contaP);
                    System.out.println("Cadastro realizado!");
                    break;
                case 3:
                    System.out.println("\nCriar Conta Investimento");
                    ContaInvestimento contaI = new ContaInvestimento();
                    System.out.println("Informe o valor investido: ");
                    contaI.setValorInvestido(ler.nextFloat());
                    ler.nextLine();
                    contas.add(contaI);
                    System.out.println("Cadastro realizado!");
                    break;
                case 4:
                    if(contas.isEmpty()){
                        System.out.println("\nNenhum cadastro foi realizado!");
                    } else{
                        Integer i = 1;
                        System.out.println("\nListagem dos Juros das Contas: ");
                        for(ContaBancaria conta : contas){
                            System.out.println("\nConta " + i++ +": ");
                            System.out.println("Tipo de conta: " + conta.getTipo());
                            
                            if(conta instanceof ContaInvestimento){
                                ContaInvestimento contaInv = (ContaInvestimento) conta;
                                System.out.println("Valor Investido: " + contaInv.getValorInvestido());
                            } else {
                                System.out.println("Saldo da conta: " + conta.getSaldo());
                            }
                            
                            if(conta.getTipo().equals("Conta Corrente") && conta.getSaldo()<0){
                                ContaCorrente exibCC = (ContaCorrente) conta;
                                System.out.println("Taxa de Juros + Taxa Adicional: " + (exibCC.getTaxaAdicional()+exibCC.getTaxaJuros()) + "%");
                            } else if(conta.getTipo().equals("Conta Investimento")){
                                ContaInvestimento contaInv = (ContaInvestimento) conta;
                                System.out.println("Taxa de Juros Variavel: " + contaInv.getTaxaJurosVar() + "%");
                            } else{
                                System.out.println("Taxa de Juros: " + conta.getTaxaJuros() + "%");
                            }
                            System.out.println("Juros calculado: " + Math.abs(conta.calcularJuros()));
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        } while(option!=0);
    }
}
