#include <stdio.h>
void main()
{
    int mat[5][5], i, j, x, soma_diag_princ=0, soma_diag_sec=0;

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
        soma_diag_sec = soma_diag_sec + mat[i][4-i];
        printf("\n");
    }
    if(soma_diag_princ==soma_diag_sec){
        printf("As somas das diagonais sao iguais!");
    }
    else {
        printf("As somas das diagonais nao sao iguais!");
    }
}