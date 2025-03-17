#include <stdio.h>
void main ()
{
    int n, i, maior;

    for (i=1;i<=10;i++){
        printf("Digite um numero: ");
        scanf("%d", &n);
        if (i==1){
            maior = n;
        }
        else {
            if (n>maior){
                maior = n;
            }
        }
    }
    printf("O maior numero e: %d", maior);
}