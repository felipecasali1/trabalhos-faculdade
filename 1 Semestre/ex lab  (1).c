#include <stdio.h>
void main()
{
    int mat[5][5], i, j, nulo=0, unico=0, coluna=0, tam=5;      //declaração das variaveis e da matriz

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);        //loop para ler as linhas da matriz
        }
        printf("\n");
    }
    printf("\n");
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat[i][j]);       //loop para somar a quantidade de zeros e uns
            if(mat[i][j]==0){
                nulo++;
            }
            if(mat[i][j]==1){
                unico++;
            }
        }
        printf("\n");
    }
    for(i=0 ; i<5 ; i++){
        coluna = 0;
        for(j=0 ; j<5 ; j++){
            coluna = coluna + mat[j][i];        //loop para verificar se a coluna é uma permutação
        }
        if(coluna!=1){
            printf("A matriz nao e de permutacao!");    //se a soma da coluna der mais que um, nao é permutação
            return 0;
        }
    }
    if(nulo==4*tam && unico==1*tam){            //se a matriz tiver a quantidade certa de zeros e uns o programa escreverá: é permutação
        printf("A matriz e de permutacao!");
    }
    else {
        printf("A matriz nao e de permutacao!");    //caso não: nao é permutação
    }
}