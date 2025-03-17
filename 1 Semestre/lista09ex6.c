#include <stdio.h>
void main()
{
    int mat[5][5], mat_t[5][5], i, j;

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            mat_t[j][i] = mat[i][j];
        }
    }

    printf("Transposta:\n");
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat_t[i][j]);
        }
        printf("\n");
    }
}