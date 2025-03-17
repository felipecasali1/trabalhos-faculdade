#include <stdio.h>
void main()
{
    int mat[5][5], i, j, res=0;

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            if(mat[i][j] = mat[j][i]){
                res = 1;
            }
            else{
                res = 0;
            }
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
    if(res=1){
        printf("\nA matriz e simetrica!");
    }
    else {
        printf("\nA matriz nao e simetrica!");
    }
}