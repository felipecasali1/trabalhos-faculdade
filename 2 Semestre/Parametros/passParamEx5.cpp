#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
/*
    Faça um programa possuindo uma função que receba um vetor A de dez elementos
    inteiros como parâmetro. Ao final dessa função, deverá ter sido gerado um vetor B
    contendo o fatorial de cada elemento de A. O vetor B deverá ser mostrado no programa
    principal.
*/
void vetorFatorial(int vetorA[], int vetorB[]){
    int i, j, fatorial;
    for(i=0 ; i<10 ; i++){
        fatorial = 1;
        for(j=1 ; j<=vetorA[i] ; j++){
            fatorial = fatorial*j;
        }
        vetorB[i] = fatorial;
        cout<<"\n"<<vetorB[i];
    }
}
int main(){
    int i, vetorA[10], vetorB[10];
    cout<<"Informe o vetor: "<<endl;
    for(i=0 ; i<10 ; i++){
        cin>>vetorA[i];
    }
    vetorFatorial(vetorA, vetorB);
    return 0;
}