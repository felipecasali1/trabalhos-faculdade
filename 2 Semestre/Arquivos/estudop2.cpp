#include <iostream>
#include <cstdio>
#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <string.h>
#include <iomanip>
using namespace std;
int main(){
    char registro[70], nome[30], cpf[25], rg[25], idade[10], escolaridade[25];
    int i, j;
    FILE *p, *p2;
    p = fopen("ex3.txt", "r");
    p2 = fopen("superiorEx2.txt", "w");
    if(p==NULL){
        cout<<"Erro de abertura!";
    } else {
        while(fgets(registro, 70, p) != NULL){
            i = j = 0;

            while(!isdigit(registro[i])){
                nome[j++] = registro[i++];
            }
            nome[j-1] = '\0';
            j=0;

            while(registro[i]!=' '){
                cpf[j++] = registro[i++];
            }
            cpf[j] = '\0';
            i++;
            j=0;

            while(registro[i]!=' '){
                rg[j++] = registro[i++];
            }
            rg[j] = '\0';
            i++;
            j=0;

            while(registro[i]!=' '){
                idade[j++] = registro[i++];
            }
            idade[j] = '\0';
            i++;
            j=0;

            while(registro[i]!='\n'){
                escolaridade[j++] = registro[i++];
            }
            escolaridade[j] = '\0';

            if(strcmpi(escolaridade, "superior")==0){
                fputs(nome, p2);
                fputs(" ", p2);
                fputs(cpf, p2);
                fputs(" ", p2);
                fputs(rg, p2);
                fputs(" ", p2);
                fputs(idade, p2);
                fputs("\n", p2);
            }
        }
        cout<<"Processo concluido!";
    }
    fclose(p);
    fclose(p2);
    return 0;
}
