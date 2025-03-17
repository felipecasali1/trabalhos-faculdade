package calcbasica;
import java.util.Scanner;

public class OperacaoMat {
    public static float soma(float n1, float n2){
        float res = n1 + n2;
        return res;
    }
    
    public static float subtracao(float n1, float n2){
        float res = n1 - n2;
        return res;
    }
    
    public static float multiplicacao(float n1, float n2){
        float res = n1 * n2;
        return res;
    }
    
    public static float divisao(float n1, float n2){
        float res = n1 / n2;
        return res;
    }
    
    public static void main(String[] args) {
        float n1, n2, res;
        char add = '+', sub = '-', div = '/', mult = '*', op;
        
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o primeiro numero: ");
        n1 = leitura.nextFloat();
        leitura.nextLine();
        
        do{
            System.out.println("+ - / *");
            System.out.println("Informe a operacao desejada: ");
            op = leitura.nextLine().charAt(0);
        } while(op!='+' && op!='-' && op!='/' && op!='*');
        
        System.out.println("Informe o segundo numero: ");
        n2 = leitura.nextFloat();
        leitura.nextLine();
        leitura.close();
        
        switch(op){
            case '+':
                System.out.println("A soma resulta em: " + soma(n1, n2));
                break;
            case '-':
                System.out.println("A subtracao resulta em: " + subtracao(n1, n2));
                break;
            case '*':
                System.out.println("A multiplicacao resulta em: " + multiplicacao(n1, n2));
                break;
            case '/':
                System.out.println("A divisao resulta em: " + divisao(n1, n2));
                break;
            default:
                System.out.println("Ocorreu um erro!");
                break;
        }
    }
}
