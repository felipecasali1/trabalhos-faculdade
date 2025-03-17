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

    printf("Digite um numero para multiplicar a segunda coluna: ");
    scanf("%d", &x);
    printf("\n");

    for(i=0 ; i<5 ; i++){
        mat[i][1] = mat[i][1]*x;
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
}