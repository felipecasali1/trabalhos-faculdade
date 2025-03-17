#include <iostream>
#include <iomanip>
#include <cstdio>
#include <string.h>
#include <cstring>
using namespace std;
void capicua(int num){
    int resto;
    if(num%11==0){
        cout<<"E capicua!";    
    } else {
        cout<<"Nao e capicua!";
    }    
}
int main(){
    int n;
    do{
        cout<<"Informe um numero de dois digitos: ";
        cin>>n;
    } while(n>=100||n<10);
    capicua(n);
    return 0;
}