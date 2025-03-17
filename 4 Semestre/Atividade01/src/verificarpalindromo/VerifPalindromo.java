package verificarpalindromo;
import java.util.Scanner;

public class VerifPalindromo {
    
    public static void main (String[] args) {
        String palavra, rev;
        char aux;
        System.out.println("Entre com a palavra: ");
        Scanner lerPalavra = new Scanner(System.in);
        palavra = lerPalavra.nextLine();
        lerPalavra.close();
        char[] p = palavra.toCharArray();
        
        for(int i=0; i<palavra.length()/2 ; i++){
            aux = p[i];
            p[i] = p[palavra.length() - i - 1];
            p[palavra.length() - i - 1] = aux;
        }

        rev = new String(p);
        if(palavra.equalsIgnoreCase(rev)){
            System.out.println("A palavra e um palindromo!");
        } else{
            System.out.println("A palavra nao e um palindromo!");
        }
    }
}
