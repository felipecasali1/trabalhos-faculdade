#include <iostream>
#include <cstdio>
#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <string.h>
#include <iomanip>
using namespace std;
int main(){
    char registro[70], nome[30], matricula[30], n1[10], n2[10], n3[10], n4[10];
    int i, j;
    float media, nota1, nota2, nota3, nota4;
    FILE *p, *p2;
    p = fopen("disciplina.txt", "r");
    p2 = fopen("aprovados.txt", "w");
    if(p==NULL){
        cout<<"Erro de abertura!";
    } else {
        while(fgets(registro, 70, p) != NULL){
            i = j = 0;

            while(registro[i]!=' '){
                matricula[j++] = registro[i++];
            }
            matricula[j] = '\0';
            i++;
            j=0;

            while(!isdigit(registro[i])){
                nome[j++] = registro[i++];
            }
            nome[j-1] = '\0';
            j=0;

            while(registro[i]!=' '){
                n1[j++] = registro[i++];
            }
            n1[j] = '\0';
            i++;
            j=0;

            while(registro[i]!=' '){
                n2[j++] = registro[i++];
            }
            n2[j] = '\0';
            i++;
            j=0;

            while(registro[i]!=' '){
                n3[j++] = registro[i++];
            }
            n3[j] = '\0';
            i++;
            j=0;

            while(registro[i]!='\n'){
                n4[j++] = registro[i++];
            }
            n4[j] = '\0';

            nota1 = atof(n1);
            nota2 = atof(n2);
            nota3 = atof(n3);
            nota4 = atof(n4);
            media = (nota1+nota2+nota3+nota4)/4;

            if(media>=6){
                fprintf(p2, "%s %s %.2f\n", matricula, nome, media);
            }
        }
        cout<<"Processo concluido!";
    }
    fclose(p);
    fclose(p2);
    return 0;
}
