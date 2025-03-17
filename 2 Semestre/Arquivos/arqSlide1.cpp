#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
    FILE *arq;
    arq = fopen("arqSlide1.txt", "w");
    char ch;
    if(arq==NULL){
        cout<<"Houve um erro na abertura!";
    } else{
        cout<<"Escreva um caractere: ";
        cin>>ch;
        while(ch!='0'){
            fputc(ch, arq);
            if(ferror(arq)){
                cout<<"Ocorreu um erro na gravação!";
            } else{
                cout<<"Digite outro caractere ou 0 para sair: ";
                cin>>ch;
            }
        }
            
    }
    fclose(arq);
    return 0;
}