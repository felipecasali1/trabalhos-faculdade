package ordenarvetor;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenarVetor {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int[] vet = new int[5];
        
        System.out.println("Entre com os numeros para o vetor: ");
        for(int i=0 ; i<5 ; i++){
            System.out.println("Numero " + (i+1) + ": ");
            vet[i] = leitura.nextInt();
            leitura.nextLine();
        }
        leitura.close();
        
        Arrays.sort(vet);
        
        System.out.println("Vetor em ordem crescente: ");
        for(int i=0 ; i<5 ; i++){
            System.out.print(vet[i] + " ");
        }
    }
}
