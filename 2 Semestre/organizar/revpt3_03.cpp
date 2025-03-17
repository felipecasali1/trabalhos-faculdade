#include <iostream>
using namespace std;
int main(){
    int matriz[5][5], num, i, j;
    cout<<"Informe a matriz: "<<endl;
    for(i=0;i<5;i++){
        cout<<"Linha "<<i+1<<": "<<endl;
        for(j=0;j<5;j++){
            cin>>matriz[i][j];
        }
    }
    cout<<"\nInforme um numero para multiplicar: ";
    cin>>num;
    
    for(j=0;j<5;j++){
            matriz[2][j] = matriz[2][j]*num;
    }
    for(i=0;i<5;i++){
        cout<<endl;
        for(j=0;j<5;j++){
            cout<<matriz[i][j]<<" ";
        }
    }
    return 0;
}