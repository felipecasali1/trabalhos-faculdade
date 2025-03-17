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
    char nome[35], cpf[20], nascimento[20], endereco[35];
    int opcao;
    p = fopen("ativ1.txt","a");
    if(p==NULL){
        cout<<"Erro de abetura!";
    } else{
        do{
            opcao = 0;
            cout<<"Realizar registro"<<endl;
            cout<<"\nInforme seu nome: ";
            _flushall();
            gets(nome);
            cout<<"Informe seu CPF: ";
            _flushall();
            gets(cpf);
            cout<<"Informe a data de nascimento: ";
            _flushall();
            gets(nascimento);
            cout<<"Informe o endereco: ";
            _flushall();
            gets(endereco);

            fputs(nome, p);
            fputs(" ", p);
            fputs(cpf, p);
            fputs(" ", p);
            fputs(nascimento, p);
            fputs(" ", p);
            fputs(endereco, p);
            fputs("\n", p);

            cout<<"\nInforme 1 para fazer outro registro ou 0 para sair: ";
            cin>>opcao;
            cout<<"\n";
        } while(opcao==1);
        cout<<"Operacao encerrada!";
    }
    fclose(p);
    return 0;
}
