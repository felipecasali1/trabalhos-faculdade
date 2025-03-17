#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;

struct Obras {
    int codigo;
    char nomeObra[30];
    char nomeAutor[30];
    char doacao[3];
};

int main(){
    Obras lista[100];
    int i, n, k, consulta;

    do {
        cout<<"Informe a quantidade de obras (<=100): ";
        cin>>n;
    } while(n<=0||n>100);

    for(i=0 ; i<n ; i++){
        cout<<"\nCadastro "<<i+1;
        cout<<"\nInforme o codigo da obra: ";
        _flushall();
        cin>>lista[i].codigo;
        cout<<"Informe 'S' para doacao ou 'N' caso nao: ";
        _flushall();
        gets(lista[i].doacao);
        cout<<"Informe o nome da obra: ";
        _flushall();
        gets(lista[i].nomeObra);
        cout<<"Informe o nome do autor: ";
        _flushall();
        gets(lista[i].nomeAutor);
    }

    cout<<"\nConsultar obras";
    do {
        cout<<"\nInforme o codigo da obra a ser consultada: ";
        _flushall();
        cin>>consulta;
        k = 0;
        for(i=0 ; i<n ; i++){
            if(consulta==lista[i].codigo){
                k = 1;                
                cout<<"\nNome: "<<lista[i].nomeObra<<endl;
                cout<<"Codigo: "<<lista[i].codigo<<endl;
                cout<<"Autor: "<<lista[i].nomeAutor<<endl;
                cout<<"Doacao: "<<lista[i].doacao<<endl;
            }
        }
        if(k!=1){
            if(consulta==1){
                cout<<"\nConsulta encerrada!"<<endl;
            } else {
                cout<<"\nO codigo nao corresponde a um cadastro!"<<endl;
            }
        }
    } while(consulta!=1);
    return 0;
}