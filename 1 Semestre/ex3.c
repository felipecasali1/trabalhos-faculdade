#include <stdio.h>
void main()
{
    int n, i, soma, p;          //variaveis para quantidade de pares, contador, soma total e o contador de pares
    soma = 0;
    p = 2;                      //soma recebe 0 e o contador de pares começa em 2
    printf("Digite a quantidade de pares a serem somados: ");
    scanf("%d", &n);                    //informa-se o numero de pares na sequencia

    for(i=1;i<=n;i++){                  //enquanto o contador (i) for menor ou igual que n, o programa executara os comandos
        soma = soma + p;                //soma recebe soma + contador de pares
        p = p+2;                        //contador de pares recebe + 2 para que se tenha a soma dos pares seguintes
    }
    printf("A soma dos %d primeiros pares resulta em: %d", n, soma);        //o programa escreve o resultado da soma dos n primeiros pares
}