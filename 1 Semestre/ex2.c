#include <stdio.h>
void main ()
{
    int i, maior, idade;        //variaveis para o contador, idades e para definir a maior idade

    for (i=1;idade!=0;i++){     //enquanto a idade digitada for diferente de 0 o programa executara os comandos
        printf("Infome a idade ou '0' para encerrar: ");
        scanf("%d", &idade);            //programa le as idades
        if(i==1){
            maior = idade;          //define-se a primeira idade como a maior
        }
        else {
            if(idade>maior){        //caso as outras idades forem maiores que a primeira elas a substituirão 
                maior = idade;
            }
        }
    }
    if(maior!=0){                   //se a idade for diferente de 0 o programa escrevera a maior idade
        printf("A maior idade é: %d", maior);
    }
    else {                              //caso a maior idade seja 0 o programa sera encerrado
        printf("Programa encerrado!");
    }
}