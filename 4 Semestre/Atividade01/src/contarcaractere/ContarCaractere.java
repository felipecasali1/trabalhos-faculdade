package contarcaractere;
import java.util.Scanner;

public class ContarCaractere {
    public static void main(String[] args) {
        int k = 0;
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com uma string: ");
        String texto = leitura.nextLine();
        System.out.println("Entre com um caractere para a contagem: ");
        char c = leitura.nextLine().charAt(0);
        leitura.close();
        char[] p = texto.toCharArray();
        texto.toLowerCase();
        c = Character.toLowerCase(c);
        
        for(int i=0 ; i<texto.length() ; i++){
            if(p[i]==c){
                k++;
            }
        }
        
        if(k==1) {
            System.out.println("O caractere '" + c + "' apareceu "+ k + " vez na frase!");
        } else if (k>1) {
            System.out.println("O caractere '" + c + "' apareceu "+ k + " vezes na frase!");
        } else {
            System.out.println("O caractere '" + c + "' nao apareceu nenhuma vez na frase!");
        }
    }
}
