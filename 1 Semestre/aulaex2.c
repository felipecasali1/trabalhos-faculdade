#include <stdio.h>
void main()
{
    int vet[10], voto, i;

    for(i=0;i<10;i++){
        vet[i] = 0;
    }

    do{
        printf("Infome seu candidato: ");
        scanf("%d", &voto);
        if (voto>=0&&voto<10){
            vet[voto]++;
        }
    } while(voto>=0);

    printf("\nQuantidade de votos: \n");
    for(i=0;i<10;i++){
        printf("%d\n", vet[i]);
    }
}