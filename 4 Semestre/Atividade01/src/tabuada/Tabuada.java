package tabuada;
import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        int num;
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe um numero para a tabuada: ");
        num = leitura.nextInt();
        leitura.nextLine();
        leitura.close();
        
        for(int i = 1; i<=10 ; i++){
            System.out.println(num + " x " + i + " = " + (num*i));
        }
    }
}
