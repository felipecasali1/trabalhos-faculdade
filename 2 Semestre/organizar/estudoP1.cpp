#include <iostream>
#include <iomanip>
#include <string.h>
#include <cstdio>
#include <cstring>
using namespace std;
int main(){
    char frase[100];
    int i, palavras;
    
    cout<<"Informe a frase: ";
    gets(frase);
    palavras = 1;

    for(i=0 ; i<strlen(frase) ; i++){
        if(frase[i]==' '){
            palavras++;
        }
    }
    cout<<"A frase possui "<<palavras<<" palavras!";
    return 0;
}
