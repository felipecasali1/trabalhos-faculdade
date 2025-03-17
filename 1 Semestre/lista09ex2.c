#include <stdio.h>
void main()
{
    int mat[5][5], i, j, soma_diag_princ=0;

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }

    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat[i][j]);
        }
        soma_diag_princ = soma_diag_princ + mat[i][i];
        printf("\n");
    }
    printf("\nA soma da diagonal principal e: %d", soma_diag_princ);
}