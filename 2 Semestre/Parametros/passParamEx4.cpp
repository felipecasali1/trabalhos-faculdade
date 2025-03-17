#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;

float valorS(int num){
    int i, j, fatorial;
    float soma;
    soma = 1;
    for(i=1 ; i<=num ; i++){
        fatorial = 1;
        for(j=2 ; j<=i ; j++){
            fatorial = fatorial*j;
        }
        soma += (float)1/fatorial;
    }
    return soma;
}

int main(){
    int n;
    cout<<"Informe um numero inteiro positivo: ";
    cin>>n;
    cout<<"A soma resulta em: "<<valorS(n);
    return 0;
}