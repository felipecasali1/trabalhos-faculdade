#include <iostream>
#include <iomanip>
#include <cstdio>
#include <string.h>
#include <cstring>
using namespace std;
void somaEntre(int num1, int num2){
    int soma, i;
    soma = 0;
    for(i=num1+1 ; i<num2 ; i++){
        soma = soma + i;
    }
    cout<<"A soma dos numeros entre "<<num1<<" e "<<num2<<" resultam em: "<<soma;
}
int main(){
    int n1, n2;
    cout<<"Informe o primeiro numero: ";
    cin>>n1;
    cout<<"Informe o segundo numero: ";
    cin>>n2;
    somaEntre(n1, n2);
    return 0;
}