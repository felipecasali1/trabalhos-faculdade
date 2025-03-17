#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
#define TAM 10
using namespace std;

struct Habitantes {
    int idade, filhos;
    char sexo[25];
    float salario;
};

int main(){
    Habitantes lista[TAM];
    int i, contF, contM;
    float salarioF, salarioM, mediaFilhos; 
    mediaFilhos = contF = contM = salarioF = salarioM = 0;

    cout<<"Informe os dados dos habitantes!"<<endl;
    for(i=0 ; i<TAM ; i++){
        cout<<"\nHabitante "<<i+1;
        cout<<"\nInforme a idade: ";
        _flushall();
        cin>>lista[i].idade;
        cout<<"Informe a quantidade de filhos: ";
        _flushall();
        cin>>lista[i].filhos;
        cout<<"Informe o sexo (masculino ou feminino): ";
        _flushall();
        gets(lista[i].sexo);
        cout<<"Informe o salario: ";
        _flushall();
        cin>>lista[i].salario;
    }

    for(i=0 ; i<TAM ; i++){
        if(strcmpi(lista[i].sexo, "masculino")==0){
            salarioM += lista[i].salario;
            contM++;
        }
        if(strcmpi(lista[i].sexo, "feminino")==0){
            salarioF += lista[i].salario;
            contF++;
        }
        mediaFilhos += lista[i].filhos;
    }

    cout<<"\nDados coletados: ";
    if(contM>0){
        cout<<"\nMedia salarial dos homens: "<<salarioM/contM;
    }else{
        cout<<"\nNenhum homem cadastrado!";
    }
    if(contF>0){
        cout<<"\nMedia salarial das mulheres: "<<salarioF/contF;
    }else{
        cout<<"\nNenhuma mulher cadastrada!";
    }
    cout<<"\nMedia de filhos: "<<mediaFilhos/TAM<<endl;
    return 0;
}