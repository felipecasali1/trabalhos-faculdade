#include <iostream>
#include <cstdio>
#include <cstring>
#include <iomanip>
#include <string.h>
using namespace std;
int main(){
    char frase[100], palavra[50][50];
    int i, j, k, l;

    cout<<"Informe uma frase: ";
    gets(frase);

    i = k = j = l = 0;
    for(i=0 ; frase[i]!='\0' ; i++){    //verifica os caracteres ate o \0
        if(frase[i]!=' '){              
            palavra[j][k] = frase[i];   //enquanto o caractere for diferente de ' ' ele sera guardado na matriz
            k++;
        }
        else{
            palavra[j][k] = '\0';       //caso for ' ' a palavra recebe \0 no final
            j++;                        //a matriz desce uma linha
            k = 0;                      //o indice e reiniciado
        }
    }
    palavra[j][k] = '\0';               //a ultima palavra recebe o \0 no final

    cout<<"Ordem inversa: ";
    for(l = j ; l>=0 ; l--){            //loop para imprimir em ordem inversa (linhas da matriz de baixo para cima)
        cout<<palavra[l];               //cout para imprimir toda a linha da matriz
        if(l>0){                        
            cout<<" ";                  //imprime-se um espaco apos a palavra ate que se chegue na ultima linha da matriz
        }
    }
    return 0;
}