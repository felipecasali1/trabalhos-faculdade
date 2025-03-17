#include <stdio.h>
void main()
{
    char vetA[20], vetB[20];
    int i, j, aux;

    for(i=0;i<20;i++){
        printf("Digite uma letra para a sequencia A: ");
        fflush(stdin);
        scanf("%c", &vetA[i]);
    }
    printf("\n");

    for(i=0;i<20;i++){
        printf("Digite uma letra para a sequencia B: ");
        fflush(stdin);
        scanf("%c", &vetB[i]);
    }

    for(i=0, j=19;i<20;i++, j--){
        aux = vetA[i];
        vetA[i] = vetB[j];
        vetB[j] = aux;
    }

    printf("\nSequencia A: \n");
    for(i=0;i<20;i++){
        printf("%c\n", vetA[i]);
    }

    printf("\nSequencia B: \n");
    for(i=0;i<20;i++){
        printf("%c\n", vetB[i]);
    }
}