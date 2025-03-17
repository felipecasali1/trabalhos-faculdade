#include <iostream>
#include <iomanip>
#include <cstdio>
#include <string.h>
#include <cstring>
using namespace std;
void reajuste(float sal, int ano){
    float reajustado;
    if(ano<10){
        reajustado = sal * 1.10;
    } else {
        reajustado = sal * 1.15;
    }
    cout<<"O salario reajustado sera de: R$"<<fixed<<setprecision(2)<<reajustado;
}
int main(){
    int anos;
    float salario;
    cout<<"Informe o salario: ";
    cin>>salario;
    cout<<"Informe o tempo de serviço em anos: ";
    cin>>anos;
    reajuste(salario, anos);
    return 0;
}