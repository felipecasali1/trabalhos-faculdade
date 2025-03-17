#include <stdio.h>
void main()
{
    int mat[5][5], i, j, linha=0, coluna=0, soma_l=0, soma_c=0;     //declara-se as variaveis e a matriz

    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){               //loop para ler a matriz
            scanf("%d", &mat[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){               //loop para escrever a matriz
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
    for(i=0 ; i<5 ; i++){           //loop para verificar se as linhas e colunas sao nulas
        soma_l = 0;
        soma_c = 0;      //zera-se a soma da linha para verificar as proximas
        for(j=0 ; j<5 ; j++){
            soma_l = soma_l + mat[i][j];    //soma-se os valores da linha
            soma_c = soma_c + mat[j][i];    //soma-se os valores da coluna
        }
        if(soma_l==0){
            linha++;        //caso a soma seja nula o programa somará 1 no contador linha
        }
        if(soma_c==0){
            coluna++;       //caso a soma seja nula o programa somará 1 no contador coluna
        }
    }
    if(linha!=0){
        printf("\n%d linhas nulas!", linha);    //caso se tenha linhas nulas, o programa escreverá
    }
    else {
        printf("\nNenhuma linha nula!");    //caso o contador seja 0, nenhuma linha nula
    }
    if(coluna!=0){
        printf("\n%d colunas nulas!", linha);   //caso se tenha colunas nulas, o programa escreverá
    }
    else {
        printf("\nNenhuma coluna nula!");   //caso o contador seja 0, nenhuma coluna nula
    }
} 