#include <iostream>
#include <cstdio>
#include <string.h>
#include <iomanip>
#include <cstring>
using namespace std;
struct Imoveis {
    char tipo[25], endereco[25], bairro[25], situacao[25];
    double valor;
};
int main(){
    Imoveis lista[50];
    int i, n;
    char busca[25];
    do{
        cout<<"Informe a quantidade de imoveis (<=50): ";
        cin>>n;
    }while(n<=0||n>50);
    for(i=0 ; i<n ; i++){
        cout<<"\nDados do imovel "<<i+1;
        cout<<"\nInforme o tipo do imovel: ";
        fflush(stdin);
        gets(lista[i].tipo);
        cout<<"Informe o endereco: ";
        fflush(stdin);
        gets(lista[i].endereco);
        cout<<"Informe o bairro: ";
        fflush(stdin);
        gets(lista[i].bairro);
        cout<<"Informe a situacao do imovel: ";
        fflush(stdin);
        gets(lista[i].situacao);
        cout<<"Informe o valor: ";
        fflush(stdin);
        cin>>lista[i].valor;
    }
    cout<<"\nQual a situacao sera pesquisada? ";
    _flushall();
    gets(busca);
    for(i=0 ; i<n ; i++){
        if(strcmpi(lista[i].situacao, busca)==0){
            cout<<"\nOpcao "<<i+1<<endl;
            cout<<"Situacao: "<<lista[i].situacao<<endl;
            cout<<"Tipo: "<<lista[i].tipo<<endl;
            cout<<"Endereco: "<<lista[i].endereco<<endl;
            cout<<"Bairro: "<<lista[i].bairro<<endl;
            cout<<"Valor: R$"<<lista[i].valor<<endl;
        }
    }
    return 0;
}