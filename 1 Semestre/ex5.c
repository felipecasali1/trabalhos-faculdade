#include <stdio.h>
void main()
{
    int i, lado, lado1=0, lado2=0, lado3=0, lado4=0, lado5=0, lado6=0;
                                                        //variaveis para o contador, para ler o lado e para o total de cada um dos lados
    for(i=1;i<=15;i++){             //o programa executará o codigo enquanto o contador for menor ou igual a 15(quantidade de lançamentos)
        printf("Informe o lado do dado: ");
        scanf("%d", &lado);                 //programa le o lado que caiu

        switch(lado){               //o programa soma 1 ao lado informado em cada um dos lançamentos
            case 1:
                lado1++;
            break;
            case 2:
                lado2++;
            break;
            case 3:
                lado3++;
            break;
            case 4:
                lado4++;
            break;
            case 5:
                lado5++;
            break;
            case 6:
                lado6++;
            break;
            default:
                printf("Lado inválido! Digite novamente: \n");
                i--;                //caso o usuario informe um lado invalido o programa não considerará como um lançamento valido
            break;
        }
    }
    printf("\nResultados: \n");
    printf("\n%d casos em lado 1\n", lado1);
    printf("%d casos em lado 2\n", lado2);
    printf("%d casos em lado 3\n", lado3);
    printf("%d casos em lado 4\n", lado4);          //o programa escreve os resultados de todos os lançamentos em cada um dos lados
    printf("%d casos em lado 5\n", lado5);
    printf("%d casos em lado 6\n", lado6);
}