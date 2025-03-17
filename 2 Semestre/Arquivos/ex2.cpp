#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cstring>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

int main(){
    char registro[70], escolha[30], modelo[30], fabricante[35], cor[20], ano[10], placa[20], valor[20];
    int i, j;
    FILE *p;
    p = fopen("ex2.txt","r");
    if(p==NULL){
        cout<<"Erro de abertura!";
    } else{
        cout<<"Informe o modelo desejado: ";
        gets(escolha);
        while(fgets(registro, 70, p) != NULL){
            i = j = 0;                              //lembrar de iniciar/resetar com 0
            while(registro[i]!=' '){
                modelo[j++] = registro[i++];
            }
            modelo[j] = '\0';
            i++;
            j=0;
            while(registro[i]!=' '){
                fabricante[j++] = registro[i++];
            }
            fabricante[j] = '\0';
            i++;
            j=0;
            while(registro[i]!=' '){
                cor[j++] = registro[i++];
            }
            cor[j] = '\0';
            i++;
            j=0;
            while(registro[i]!=' '){
                ano[j++] = registro[i++];
            }
            ano[j] = '\0';
            i++;
            j=0;
            while(registro[i]!=' '){
                placa[j++] = registro[i++];
            }
            placa[j] = '\0';
            i++;
            j=0;
            while(registro[i]!='\n'){
                valor[j++] = registro[i++];
            }
            valor[j] = '\0';
            if(strcmpi(escolha, modelo)==0){
                cout<<"\nCor: "<<cor<<", ano: "<<ano<<", valor: R$"<<valor<<endl;
            }
        }
    }
    fclose(p);
    return 0;
}
