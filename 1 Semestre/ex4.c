#include <stdio.h>
void main()
{
    int n, soma;        //variaveis para o numero e para a soma
    soma = 0;
    n = 1;          //soma recebe 0 e N recebe 1, que sera substituido no for

    for( ;n!=0; ){          //programa executara os comandos enquanto o numero digitado for diferente de 0
        printf("Digite um numero qualquer ou 0 para confirmar: ");
        scanf("%d", &n);        //o programa le o numero
        if(n%5==0){                 //caso o numero for um multiplo de 5 ele será adicionado na soma
            soma = soma + n;
        }
    }
    printf("A soma dos multiplos resulta em: %d", soma);        //escreve-se a soma dos multiplos
}