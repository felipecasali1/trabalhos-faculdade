#include <stdio.h>
void main()
{
    int mat[5][5], matB[8], i, j;   //declara-se as variaveis e matrizes

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){       //loop para ler a matriz
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat[i][j]);   // loop para exibir a matriz
        }
        printf("\n");
    }
    for(j=0 ; j<8 ; j++){
        matB[j] = 0;        //loop para zerar a contagem das peças
    }
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){       //loop para somar quantas peças se tem de cada na matriz
            matB[mat[i][j]]++;
        }
    }
    printf("\n");
    for(j=1 ; j<8 ; j++){
        printf("Pecas %d: %d\n", j , matB[j]);      //loop para exibir os resultados
    }
}