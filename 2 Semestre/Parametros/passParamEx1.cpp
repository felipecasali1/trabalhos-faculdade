#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
float medias(float n1, float n2, float n3, char letra){
    float media;
    if(letra=='A'||letra=='a'){
        media = (n1+n2+n3)/3;
    } else if(letra=='P'||letra=='p'){
        media = (n1*0.5)+(n2*0.3)+(n3*0.2);
    }
    return media;
}
int main(){
    float n1, n2, n3;
    char opt;
    cout<<"Informe A para media aritmetica e P para ponderada: ";
    _flushall();
    cin>>opt;
    cout<<"\nInforme a primeira nota: ";
    _flushall();
    cin>>n1;
    cout<<"Informe a segunda nota: ";
    _flushall();
    cin>>n2;
    cout<<"Informe a terceira nota: ";
    _flushall();
    cin>>n3;
    cout<<"\nA media das notas e: "<<fixed<<setprecision(2)<<medias(n1, n2, n3, opt)<<endl;
    return 0;
}