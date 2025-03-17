#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
    FILE *p;
    char ch;
    p = fopen("arqSlide2.txt", "r");
    if(p==NULL){
        cout<<"Erro na abertura!";
    } else{
        while(!feof(p)){
            ch = fgetc(p);
            if(ferror(p)){
                cout<<"Erro na leitura!";
            } else{
                cout<<"Caractere lido: "<<ch;
            }
        }
    }
    fclose(p);
    return 0;
}