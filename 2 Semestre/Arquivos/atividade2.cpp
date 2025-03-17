#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
int main(){
    FILE *p;
    char registro[80], identidade[20], nome[35], idade[5], maisVelho[40];
    int i, j, k, m, maiorIdade, comparar, teste;
    p = fopen("atividade2.txt","r");
    if(p==NULL){
        cout<<"Erro de abetura!";
    } else{
        k = maiorIdade = teste = 0;
        while(fgets(registro, 80, p) != NULL){
            i = j = m = 0;
            while(registro[i]!=' '){
                identidade[j++] = registro[i++];
            }
            identidade[j] = '\0';
            i++;
            m = i;
            j=0;
            while(!isdigit(registro[i])){
                nome[j++] = registro[i++];
            }
            nome[j-1] = '\0';
            j=0;
            while(registro[i]!='\n'){
                idade[j++] = registro[i++];
            }
            idade[j] = '\0';

            k++;
            comparar = atoi(idade);
            if(comparar>maiorIdade){
                maiorIdade = comparar;
                i = m;
                j = 0;
                while(registro[i]!='\n' && !isdigit(registro[i])){
                    maisVelho[j++] = registro[i++];
                }
                maisVelho[j-1] = '\0';
                teste = 1;
            }
        }
    }
    if(teste==1){
        cout<<"O total de alunos lidos foram: "<<k<<endl;
        cout<<"O aluno mais velho e: "<<maisVelho<<", "<<maiorIdade<<"."<<endl;
    } else{
        cout<<"Erro!";
    }
    fclose(p);
    return 0;
}
