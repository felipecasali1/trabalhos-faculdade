#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
struct BancoX{
    char nome[30];
    int cpf;
    int telefone;
    char endereco[30];
    int numConta;
    float saldo;
};
int main(){
    int n, i, contaDep, k;
    float valorDep;
    BancoX lista[50];
    do{
        cout<<"Informe a quantidade de clientes: ";
        cin>>n;
    }while(n>50||n<1);
    for(i=0 ; i<n ; i++){
        cout<<"\nCadastro do cliente "<<i+1;
        cout<<"\nInforme o nome: ";
        _flushall();
        gets(lista[i].nome);
        cout<<"Informe o cpf: ";
        _flushall();
        cin>>lista[i].cpf;
        cout<<"Informe o telefone: ";
        _flushall();
        cin>>lista[i].telefone;
        cout<<"Informe o endereco: ";
        _flushall();
        gets(lista[i].endereco);
        cout<<"Informe o numero da conta: ";
        _flushall();
        cin>>lista[i].numConta;
        cout<<"Informe o saldo da conta: ";
        _flushall();
        cin>>lista[i].saldo;
    }
    do{
        cout<<"\nInforme o numero da conta para fazer o deposito ou -1 para sair: ";
        cin>>contaDep;
        cout<<"Informe o valor do deposito: ";
        cin>>valorDep;
        k = 0;
        for(i=0 ; i<n ; i++){
            if(contaDep==lista[i].numConta){
                lista[i].saldo += valorDep;
                cout<<"\nDados atualizados: ";
                cout<<"\nNome: "<<lista[i].nome;
                cout<<"\nCPF: "<<lista[i].cpf;
                cout<<"\nTelefone: "<<lista[i].telefone;
                cout<<"\nEndereco: "<<lista[i].endereco;
                cout<<"\nConta: "<<lista[i].numConta;
                cout<<"\nSaldo: R$"<<fixed<<setprecision(2)<<lista[i].saldo<<endl;
                k++;
            }
            if(k==0 && i==n-1){
                cout<<"\nNenhuma conta correspondente!"<<endl;
            }    
        }
    } while(contaDep!=-1);
    return 0;
}