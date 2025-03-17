package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import entities.Animal;

public class Main {
    public static void main(String[] args) {
        List <Animal>animais = new LinkedList();
        Scanner ler = new Scanner(System.in);
        int opt = 0;
        
        do {
            System.out.println("\n[     MENU     ]");         
            System.out.println("----------------");            
            System.out.println(((char)124) + "1 - Cadastrar " + ((char)124));
            System.out.println(((char)124) + "2 - Listar    " + ((char)124));
            System.out.println(((char)124) + "0 - Sair      " + ((char)124));
            opt = ler.nextInt();
            ler.nextLine();
            
            switch(opt){
                case 0:
                    System.out.println("Finalizando...");
                    break;
                case 1:
                    Animal animal = new Animal();
                    System.out.println("\nInforme o nome do animal: ");
                    animal.setNome(ler.nextLine());
                    System.out.println("Informe a especie do animal: ");
                    animal.setEspecie(ler.nextLine());
                    System.out.println("Informe a cor do animal: ");
                    animal.setCor(ler.nextLine());
                    System.out.println("Informe o habitat do animal: ");
                    animal.setHabitat(ler.nextLine());
                    System.out.println("Informe a idade do animal: ");
                    animal.setIdade(ler.nextInt());
                    ler.nextLine();
                    System.out.println("Informe o peso do animal: ");
                    animal.setPeso(ler.nextFloat());
                    ler.nextLine();
                    animais.add(animal);
                    break;
                case 2:
                    if(animais.isEmpty()){
                        System.out.println("\nNenhum animal cadastrado!");
                    } else{
                        for(int i=0 ; i<animais.size() ; i++){
                            Animal exibAnimal = animais.get(i);
                            System.out.println("\nAnimal " + i+1);
                            System.out.println("Nome: " + exibAnimal.getNome());
                            System.out.println("Especie: " + exibAnimal.getEspecie());
                            System.out.println("Cor: " + exibAnimal.getCor());
                            System.out.println("Habitat: " + exibAnimal.getHabitat());
                            System.out.println("Idade: " + exibAnimal.getIdade());
                            System.out.println("Peso: " + exibAnimal.getPeso());
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(opt!=0);
    }
}
