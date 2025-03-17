package verificarprimo;
import java.util.Scanner;

public class VerificarPrimo {
    public static void main(String[] args) {
        int num;
        Scanner leitura = new Scanner(System.in);
        do{
            System.out.println("Entre com um numero ou 0(zero) para sair: ");
            num = leitura.nextInt();
            leitura.nextLine();
            int k = 0;
            for(int i=1 ; i<=num ; i++){
                if(num%i==0){
                    k++;
                }
            }
            if(k==2){
                System.out.println("O numero e primo!");
            } else{
                System.out.println("O numero nao e primo!");
            }
        } while(num!=0);
        leitura.close();
    }
}
