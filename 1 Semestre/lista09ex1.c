#include <stdio.h>
void main()
{
    int mat[5][5], i, j, x;

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }

    printf("Digite um numero para multiplicar a matriz: ");
    scanf("%d", &x);
    printf("\nResultado: \n");

    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            mat[i][j] = mat[i][j]*x;
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
}