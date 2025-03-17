package fatorial;

import java.util.Scanner;


public class Fatorial {
    public static void main(String[] args) {
        int fat = 1, num;
        Scanner leitura = new Scanner(System.in);
        
        do{
            System.out.println("Entre com um numero para o fatorial: ");
            num = leitura.nextInt();
            leitura.nextLine();
        } while(num<0);
        leitura.close();
        
        for(int i=num ; i>1 ; i--){
            fat *= i;
        }
        
        System.out.println("O fatorial de " + num + " é: " + fat);
    }
}
