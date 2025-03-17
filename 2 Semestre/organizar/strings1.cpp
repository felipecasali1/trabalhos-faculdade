#include <iostream>
#include <cstdio>//gets
#include <cstring>//cpy
#include <string.h>//strlen, strlwr, strupr, strcmp, strcmpi, toupper, tolower
#include <iomanip>//<<fixed<<setprecision()
using namespace std;
int main(){
    char string1[15] = "TESTES", string2[15] = "testes", nome[30], sobrenome[20], branco[5] = " ";
    int i;
    cout<<strlwr(string1)<<endl;//printa em minusculas
    cout<<strupr(string2);//printa em maiusculas
    if(strcmp(string1, string2)==0){//strcmp diferencia A de a
        cout<<"\nstrcmp: iguais!";
    } else{
        cout<<"\nstrcmp: diferentes!";
    }
    if(strcmpi(string1, string2)==0){//strcmpi nao diferencia
        cout<<"\nstrcmpi: iguais!";
    } else{
        cout<<"\nstrcmpi: diferentes!";
    }
    cout<<"\nInforme seu nome em minusculas: ";
    cin>>nome;
    nome[0] = toupper(nome[0]);//uppercase uma letra especifica
    cout<<nome<<endl;
    for(i=0;i<(strlen(nome));i++){//uppercase everything
        nome[i] = toupper(nome[i]);
        cout<<nome<<endl;
    }
    for(i=1;i<(strlen(nome));i++){//lowercase everything except the first
        nome[i] = tolower(nome[i]);
    }
    cout<<"\nInforme seu sobrenome em minusculas: ";
    cin>>sobrenome;
    sobrenome[0] = toupper(sobrenome[0]);
    strcat(nome, branco);
    strcat(nome, sobrenome);
    cout<<"Seja bem-vindo "<<nome<<"!";
    return 0;
}
