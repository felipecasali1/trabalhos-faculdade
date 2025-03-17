package contarvogais;
import java.util.Scanner;

public class ContarVogal {
    public static void main(String[] args) {
        int k = 0;
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com uma string: ");
        String texto = leitura.nextLine();
        leitura.close();
        char[] p = texto.toCharArray();
        
        for(int i=0 ; i<texto.length() ; i++){
            if(p[i]=='a' || p[i]=='e' || p[i]=='i' || p[i]=='o' || p[i]=='u'){
                k++;
            }
        }
        
        System.out.println("O total de vogais e: " + k);
    }
}
