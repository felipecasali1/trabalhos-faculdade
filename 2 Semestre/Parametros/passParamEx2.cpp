#include <iostream>
#include <iomanip>
#include <cstring>
#include <string.h>
#include <cstdio>
using namespace std;
int totalMinutos(int hIni, int mIni, int hFim, int mFim){
    float totalH, totalM;
    
    if(hFim>=hIni){
        totalH = hFim - hIni;
    } else{
        totalH = 24 - (hIni - hFim);
    }
    
    if(mFim>=mIni){
        totalM = mFim - mIni;
    } else{
        totalM = 60 - mIni + mFim;
        totalH = totalH - 1;
    }

    if(hIni==hFim&&mFim<hIni){
        totalH += 24;
    }

    // se colocar 12:20 inicio e 12:10 final nao da certo
    
    return totalH * 60 + totalM;
}
int main(){
    int hIni, mIni, hFim, mFim;
    cout<<"Informe a hora de inicio: ";
    fflush(stdin);
    cin>>hIni;
    cout<<"Informe os minutos do inicio: ";
    fflush(stdin);
    cin>>mIni;
    cout<<"Informe a hora do fim: ";
    fflush(stdin);
    cin>>hFim;
    cout<<"Informe os minutos do fim: ";
    fflush(stdin);
    cin>>mFim;
    cout<<"\nO total de minutos foi de: "<<totalMinutos(hIni, mIni, hFim, mFim);
    return 0;
}