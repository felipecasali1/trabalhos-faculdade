#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <string.h>
#include <cstdio>
#include <locale.h>
using namespace std;

void calcular(float &total, float &desconto, float &valorFinal){
    valorFinal = total * ((100-desconto)/100);
}

void exibir(float &total, float &desconto, float &valorFinal){
    float valorDescontado;
    valorDescontado = total * (desconto/100);
    cout<<"\nValor original: R$"<<fixed<<setprecision(2)<<total<<endl;
    cout<<"Desconto ("<<desconto<<"%): R$"<<fixed<<setprecision(2)<<valorDescontado<<endl;
    cout<<"Valor final: R$"<<fixed<<setprecision(2)<<valorFinal<<endl;
}

int main(){
    float total, desconto, valorFinal;
    int option;
    cout<<"Calculo de desconto em compras"<<endl;
    do{
        option = 1;

        do{
            cout<<"\nDigite o valor total da compra: ";
            cin>>total;
            if(total<=0){
                cout<<"Digite um valor valido! Tente novamente!"<<endl;
            }
        } while(total<=0);

        do{
            cout<<"\nDigite a taxa de desconto, caso necessario utilize ponto no lugar da virgula!: ";
            cin>>desconto;
            if(desconto<0 || desconto>100){
                cout<<"Digite um valor valido! Tente novamente!"<<endl;
            }
        } while(desconto<0 || desconto>100);

        calcular(total, desconto, valorFinal);
        exibir(total, desconto, valorFinal);

        cout<<"\nDeseja realizar outro calculo?"<<endl;
        cout<<"Digite '1' para sim ou '0' para sair!"<<endl;
        cin>>option;

    } while(option!=0);
    cout<<"\nPrograma encerrado!"<<endl;
    return 0;
}
