#include <iostream>
#include <stdio.h>
#include <iomanip>
#include <cstdio>
#include <string.h>
#include <cstring>
#include <stdlib.h>
using namespace std;

int main(){
    int i, j, qntd;
    char registro[50], cod[10], nome[20], estoq[10], preco[10];
    FILE *p;
    p = fopen("ex1.txt","r");
    if(p==NULL){
        cout<<"Erro de abertura!";
    } else{
        cout<<"Produtos com mais de 100 unidades: "<<endl;
        while(fgets(registro, 50, p)!= NULL){   // le em registro até achar o final, tamanho deve ser maior que a linha
            i = j = 0;

            while(registro[i] != ' '){          // salvar o codigo em outra string, para no espaco
                cod[j++] = registro[i++];       // while incrementa apos a primeira vez
            }
            cod[j] = '\0';                      // \0 no final do codigo
            i++;                                // pula o espaço, chega na letra
            j = 0;                              //copiador zerado

            while(!isdigit(registro[i])){
                nome[j++] = registro[i++];
            }
            nome[j-1] = '\0';                   // -1 pois espaço tbm nao e digito
            j=0;                                //copiador zerado

            while(registro[i] != ' '){
                estoq[j++] = registro[i++];
            }
            estoq[j] = '\0';
            i++;
            j=0;
            while(registro[i]!='\n'){           //achar o fim da linha(lembrar de dar enter no arquivo)
                preco[j++] = registro[i++];
            }
            preco[j] = '\0';

            qntd = atoi(estoq);                 // ATOI string para int em outra var
            if(qntd > 100){
                cout<<cod<<" "<<nome<<" R$"<<preco<<endl;
            }
        }

    }
    fclose(p);
    return 0;
}
