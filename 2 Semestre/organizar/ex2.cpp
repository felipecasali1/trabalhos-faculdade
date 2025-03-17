#include <iostream>
#include <cstdio>
#include <cstring>
#include <iomanip>
#include <string.h>
using namespace std;
int main(){
    char frase[100];
    int a, e, i, o, u, k;
    a = e = i = o = u = 0;
    cout<<"Entre com uma frase: ";
    gets(frase);
    for(k=0 ; k<strlen(frase) ; k++){
        if(frase[k]=='a'||frase[k]=='A'){
            a++;
        } else{
            if(frase[k]=='e'||frase[k]=='E'){
                e++;
            } else{
                if(frase[k]=='i'||frase[k]=='I'){
                    i++;
                } else{
                    if(frase[k]=='o'||frase[k]=='O'){
                        o++;
                    } else{
                        if(frase[k]=='u'||frase[k]=='U'){
                            u++;
                        }
                    }
                }
            }
        }
    }
    cout<<"\nQuantidade de vogais (a): "<<a;
    cout<<"\nQuantidade de vogais (e): "<<e;
    cout<<"\nQuantidade de vogais (i): "<<i;
    cout<<"\nQuantidade de vogais (o): "<<o;
    cout<<"\nQuantidade de vogais (u): "<<u;
    return 0;
}