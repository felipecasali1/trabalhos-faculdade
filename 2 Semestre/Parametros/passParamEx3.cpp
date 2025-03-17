#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
void maiorMenor(int n1, int n2, int n3, int n4, int n5, int &maior, int &menor){
    int num[5] = {n1,n2,n3,n4,n5}, i;
    menor = n1;
    maior = n5;
    for(i=0 ; i<5 ; i++){
        if(num[i]<menor){
            menor = num[i];
        }
        if(num[i]>maior){
            maior = num[i];
        }
    }
}
int main(){
    int n1, n2 ,n3 ,n4 ,n5, maior, menor;
    maior = menor = 0;
    cout<<"Informe o primeiro numero: ";
    _flushall();
    cin>>n1;
    cout<<"Informe o segundo numero: ";
    _flushall();
    cin>>n2;
    cout<<"Informe o terceiro numero: ";
    _flushall();
    cin>>n3;
    cout<<"Informe o quarto numero: ";
    _flushall();
    cin>>n4;
    cout<<"Informe o quinto numero: ";
    _flushall();
    cin>>n5;
    maiorMenor(n1, n2, n3, n4, n5, maior, menor);
    cout<<"\nO maior numero e: "<<maior;
    cout<<"\nO menor numero e: "<<menor;
    return 0;
}