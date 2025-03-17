#include <stdio.h>
void main()
{
    int opcao, c;
    float n1, n2, res;              //declaração das variaveis

    do {
        printf("\nDigite 0 para sair!");
        printf("\nDigite 1 para adição!");
        printf("\nDigite 2 para subtração!");
        printf("\nDigite 3 para multiplicação!");
        printf("\nDigite 4 para divisão!");
        printf("\nDigite 5 para potenciação!\n");
        scanf("%d", &opcao);                        //o programa le a opção selecionada

        switch(opcao){                              //o programa rodara o codigo referente à opção escolhida
            case 0:
                printf("Calculadora encerrada!");       //caso for 0 a calculadora encerrará
            break;
            case 1:
                printf("Informe o primeiro número: ");
                scanf("%f", &n1);
                printf("Informe o segundo número: ");       //caso 1 o programa somará 2 numeros digitados e apresentara a resposta
                scanf("%f", &n2);
                res = n1 + n2;
                printf("A soma resulta em: %g\n", res);
            break;
            case 2:
                printf("Informe o primeiro número: ");
                scanf("%f", &n1);
                printf("Informe o segundo número: ");       //caso 2 o programa irá subtrair 2 numeros digitados e apresentara a resposta
                scanf("%f", &n2);
                res = n1 - n2;
                printf("A subtração resulta em: %g\n", res);
            break;
            case 3:
                printf("Informe o primeiro número: ");
                scanf("%f", &n1);
                printf("Informe o segundo número: ");       //caso 3 o programa irá multiplicar 2 numeros digitados e apresentara a resposta
                scanf("%f", &n2);
                res = n1 * n2;
                printf("A multiplicação resulta em: %g\n", res);
            break;
            case 4:
                printf("Informe o dividendo: ");
                scanf("%f", &n1);
                printf("Informe o divisor: ");       //caso 4 o programa dividira 2 numeros digitados e apresentara a resposta, exceto caso o divisor for 0
                scanf("%f", &n2);
                if(n2==0) {
                    printf("O divisor deve ser diferente de zero!\n");
                }
                else {
                    res = n1/n2;
                    printf("A divisão resulta em: %g\n", res);
                }
            break;
            case 5:
                printf("Informe a base: ");
                scanf("%f", &n1);
                printf("Informe o expoente: ");
                scanf("%f", &n2);
                c = 1;
                res = 1;                //caso 5 o programa irá ler a base e o expoente, e rodará o código enquanto o contador (c) for menor ou igual o expoente
                while(c<=n2) {
                    res = res * n1;     //res receberá um novo valor (res * base) enquanto o while for verdadeiro
                    c++;
                }
                printf("O resultado é: %g\n", res);         //resultado é apresentado
            break;
            default:                                //caso a opção digitada nao esteja incluida nos cases o programa escreverá "opção invalida"
                    printf("Opção inválida!\n");
            break;
        }
    } while(opcao!=0);              //o programa continuará exibindo o menu enquanto a opção digitada não for 0
}