#include <stdio.h>
void main()
{
    int mat[5][5], i, j, soma_linha=0, soma_coluna=0, soma_diag_princ=0, soma_diag_sec=0, soma_linha_ant=0, soma_coluna_ant=0;
                                                //delcaração das variaveis e da matriz
    for(i=0 ; i<5 ; i++){
        printf("Linha %d\n", i);
        for(j=0 ; j<5 ; j++){
            scanf("%d", &mat[i][j]);        //loop para ler a matriz
        }
        printf("\n");
    }
    printf("\n");
    for(i=0 ; i<5 ; i++){
        for(j=0 ; j<5 ; j++){
            printf("%d ", mat[i][j]);       //loop para escrever a matriz
        }
        printf("\n");
    }

    for(i=0 ; i<5 ; i++){
        soma_linha = soma_coluna = 0;           //zerar as somas apos o fim do loop de j
        for(j=0 ; j<5 ; j++){
            soma_linha = soma_linha + mat[i][j];        //soma dos valores da linha
            soma_coluna = soma_coluna + mat[j][i];      //soma dos valores da coluna
        }
        soma_diag_princ = soma_diag_princ + mat[i][i];      //soma dos valores da diagonal principal
        soma_diag_sec = soma_diag_sec + mat[i][4-i];        //soma dos valores da diagonal secundaria

        if(i==0){       //será guardado o valor das somas da primeira linha e da primeira coluna (1)
            soma_linha_ant = soma_linha;
            soma_coluna_ant = soma_coluna;
        }
        else {              //as proximas somas serão comparadas às anteriores
            if (soma_linha != soma_linha_ant || soma_coluna != soma_coluna_ant || soma_linha!= 1){    //
                printf("\nA matriz nao e um quadrado magico");  //caso diferentes de 1, resultado negativo
                break;
            }
        }
    }
    if(soma_linha==soma_coluna && soma_linha==soma_diag_princ && soma_diag_princ==soma_diag_sec){
            printf("\nA matriz e um quadrado magico");      //caso todas as somas iguais, quadrado magico
    }
}