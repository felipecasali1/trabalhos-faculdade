package convertertemp;
import java.util.Scanner;

public class ConverterTemp {
    public static float celsiusFahrenheit(float valor){
        return (valor*(9/5)) + 32;
    }
    
    public static float fahrenheitCelsius(float valor){
        return (9/5)*(valor - 32);
    }
    
    public static void main(String[] args) {
        int opt = 0;
        float valor = 0.00F;
        Scanner ler = new Scanner(System.in);
        
        do{
            System.out.println("\nEscolha uma opcao: ");
            System.out.println("1 - Celsius para Fahrenheit");
            System.out.println("2 - Fahrenheit para Celsius");
            System.out.println("0 - Para sair");
            opt = ler.nextInt();
            ler.nextLine();
            
            switch(opt){
                case 0:
                    break;
                case 1:                
                    System.out.println("\nInforme o valor em ºC: ");
                    valor = ler.nextInt();
                    ler.nextLine();
                    System.out.println("O resultado e: " + celsiusFahrenheit(valor) + "ºF ");
                    break;
                case 2:
                    System.out.println("\nInforme o valor em ºF: ");
                    valor = ler.nextInt();
                    ler.nextLine();
                    System.out.println("O resultado e: " + fahrenheitCelsius(valor) + "ºC ");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(opt!=0);
        ler.close();
    }
}