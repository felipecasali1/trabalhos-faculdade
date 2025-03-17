#include <stdio.h>
void main ()
{
    int i, p;
    float a;            //variaveis para o contador, quantidade de pessoas(1.80+) e para alturas
    p = 0;
    for (i=1;i<=10;i++){
        printf("Informe a altura em metros: ");         //enquanto o contador for menor ou igual a 10 o programa executara os comandos
        scanf("%f", &a);

        if(a>=1.80){                                    //informa-se a altura e caso ela for maior que 1.80 é somado 1 ao contador p
            p++;
        }
    }
    if (p==0){
        printf("Nenhuma pessoa mede mais de 1.80m");
    }
    else {
        if(p>1){                //imprime a quantidade de pessoas com mais de 1.80m, caso existam, sejam mais de uma ou apenas uma
            printf("%d pessoas medem mais de 1.80m", p);
        }
        else {
            printf("%d pessoa mede mais de 1.80m", p);
        }
    }
}