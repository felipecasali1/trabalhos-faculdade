#include <iostream>
#include <cstdio>
#include <cstring>
#include <iomanip>
#include <string.h>
using namespace std;
int main(){
    char palavra[15], verificar[15];
    int i, j;
    cout<<"Infome uma palavra: ";
    cin>>palavra;
    for(i=0, j=strlen(palavra)-1 ; i<strlen(palavra) ; i++, j--){
        verificar[j] = palavra[i];
    }
    verificar[strlen(palavra)] = '\0';
    if(strcmpi(palavra, verificar)==0){
        cout<<"A palavra e um palindromo!";
    } else{
        cout<<"A palavra nao e um palindromo!";
    }
    return 0;
}
