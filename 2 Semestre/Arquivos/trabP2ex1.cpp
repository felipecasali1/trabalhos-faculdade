#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;

int main(){
    char nomeArq[30], palavra[35], registro[80], ch, comparar[35];
    int option, l, k, i, j, linha;
        do{
            cout<<"\n    [          Menu          ]"<<endl;
            cout<<"\nDigite 1 para Leitura de Arquivo";
            cout<<"\nDigite 2 para Contagem de Linhas e Palavras";
            cout<<"\nDigite 3 para Busca por palavra-chave";
            cout<<"\nDigite 0 para sair"<<endl<<endl;
            cin>>option;

            if(option==1){
                FILE *p;
                cout<<"\nInforme o nome do arquivo: ";
                cin>>nomeArq;
                p = fopen(nomeArq, "r");
                if(p==NULL){
                    cout<<"Erro de abertura!";
                } else {
                    cout<<"Texto do arquivo: "<<endl<<endl;
                    while(fgets(registro, 80, p) != NULL){
                        cout<<registro;
                    }
                }
                cout<<endl;
                fclose(p);
                option = 5;
            }

            if(option==2){

                FILE *p;
                cout<<"\nInforme o nome do arquivo: ";
                cin>>nomeArq;
                p = fopen(nomeArq, "r");
                if(p==NULL){
                    cout<<"Erro de abertura!";
                } else {
                    k = 0;
                    l = 1;
                    while(!feof(p)){
                        ch = fgetc(p);
                        if(ch==' '){
                            k++;
                        }
                        if(ch=='\n'){
                            l++;
                            k++;
                        }
                    }
                    k++;
                    cout<<"\n    O arquivo contem "<<k<<" palavras!"<<endl;
                    cout<<"    O arquivo contem "<<l<<" linhas!"<<endl;
                }
                cout<<endl;
                fclose(p);
                option = 5;
            }

            if(option==3){
                FILE *p;
                cout<<"\nInforme o nome do arquivo: ";
                cin>>nomeArq;
                cout<<"\nInforme a palavra: ";
                _flushall();
                gets(palavra);
                p = fopen(nomeArq, "r");
                if(p==NULL){
                    cout<<"Erro de abertura!";
                } else {
                    linha = 0;
                    cout<<endl;
                    while(fgets(registro, 100, p)!=NULL){
                        linha++;
                        if(strstr(registro, palavra) != NULL){
                            cout<<"     Linha "<<linha<< ": "<<registro<<endl;
                        }
                    }
                }
                cout<<endl;
                fclose(p);
                option = 5;
            }

            if(option==0){
                cout<<"\nPrograma encerrado!"<<endl;
            }
        } while(option!=0);
    return 0;
}
