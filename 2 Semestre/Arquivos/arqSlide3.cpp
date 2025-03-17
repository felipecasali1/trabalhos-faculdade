#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;
int main(){
    FILE *p;
    p = fopen("arqSlide3.txt", "a");
    char cadeia[25];
    if(p==NULL){
        cout<<"Erro de abertura!";
    } else{
        cout<<"\nDigite seu nome: ";
        gets(cadeia);
        while(strcmpi(cadeia, "fim")!=0){//strcmp retorna 0 para strings iguais
            fputs(cadeia, p);
            if(ferror(p)){
                cout<<"\nErro na gravação!";
            }else{
                cout<<"\nCadeia gravada!";
                cout<<"\nInforme outra cadeia ou \"fim\" para sair: ";
                gets(cadeia);
            }
        }
    }
    fclose(p);
    return 0;
}
