#include <iostream>
#include <locale.h>
#include <iomanip>  
using namespace std;
int main(){
    setlocale(LC_ALL, " ");//permite acentuação e etc...

    int codigo;
    float valor;

    cout<<"Informe o código do produto: ";
    cin>>codigo;
    cout<<"Informe o valor do produto: ";
    cin>>valor;

    switch(codigo){
        case 1001:
            valor = valor*0.78;
            break;
        case 1254:
            valor = valor*0.70;
            break;
        case 1548:
            valor = valor*0.68;
            break;
        case 1687:
            valor = valor*0.63;
            break;
        case 1923:
            valor = valor*0.60;
            break;
        default:
            cout<<"Produto sem desconto!";
            break;
    }
    cout<<"O valor descontado do produto é de: R$"<<fixed<<setprecision(2)<<valor;
    //<<fixed<<setprecision(casas) limita apos a virgula!
    return 0;
}