package somavetor;
import java.util.Scanner;

public class SomaArray {
    public static void main(String[] args) {
        int[] vet = new int[5];
        int soma = 0;
        Scanner leitura = new Scanner(System.in);
        
        System.out.println("Informe 5 numeros inteiros: ");
        
        for(int i = 0 ; i<5 ; i++){
            System.out.println("Numero " + (i+1) + ": ");
            vet[i] = leitura.nextInt();
            leitura.nextLine();
            soma += vet[i];
        }
        leitura.close();
        
        System.out.println("A soma dos numeros resulta em: " + soma);
    }
}
