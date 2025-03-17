#include <iostream>
#include <iomanip>
#include <cstdio>
#include <string.h>
#include <cstring>
using namespace std;
void converter(float kilometro){
    float milhas;
    milhas = kilometro/1.609;
    cout<<"Distancia convertida em milhas: "<<fixed<<setprecision(2)<<milhas;
}
int main(){
    float km;
    cout<<"Informe a distancia em km: ";
    cin>>km;
    converter(km);
    return 0;
}