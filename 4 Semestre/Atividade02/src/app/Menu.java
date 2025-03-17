package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import entidade.Veiculo;

public class Menu {
    public static void main(String[] args) {
        int opt = 0, cad = 0, tam = 0;
        Scanner ler = new Scanner(System.in);
        Veiculo veiculo;
        List <Veiculo>veiculos = new LinkedList();
        
        do{
            System.out.println("\nMENU");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("0 - Sair");
            opt = ler.nextInt();
            ler.nextLine();
            
            switch(opt){
                case 0:
                    break;
                case 1:
                    do{
                        System.out.println("\nInforme a quantidade de cadastros: ");
                        tam = ler.nextInt();
                        ler.nextLine();
                    } while(tam<1);
                    
                    for(int i=0 ; i<tam ; i++){
                        veiculo = new Veiculo();
                        System.out.println("\nEntre com o modelo: ");
                        veiculo.modelo = ler.nextLine();
                        System.out.println("Entre com a marca: ");
                        veiculo.marca = ler.nextLine();
                        System.out.println("Entre com a categoria: ");
                        veiculo.categoria = ler.nextLine();
                        System.out.println("Entre com o ano: ");
                        veiculo.ano = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Entre com o valor: ");
                        veiculo.valor = ler.nextFloat();
                        ler.nextLine();
                        veiculos.add(veiculo);
                        System.out.println("Cadastro realizado!");
                        cad++;
                    }
                    break;
                case 2:
                    if(cad>0){
                        for(int i=0 ; i<tam ; i++){
                            System.out.println("\nVeiculo " + (i+1));
                            veiculos.get(i).showAll();
                        }
                    } else{
                        System.out.println("Nenhum cadastro foi realizado!");
                    }
            }
        } while(opt!=0);
        ler.close();
    }
}
