#include <iostream>
using namespace std;
int main(){
    int matriz[5][5], i, j;
    float somaDP, somaDS;
    somaDP = somaDS = 0;
    cout<<"Informe a matriz!"<<endl;
    for(i=0;i<5;i++){
        cout<<"Informe 5 numeros para a linha "<<i+1<<": "<<endl;
        for(j=0;j<5;j++){
            cin>>matriz[i][j];
        }
    }
    for(i=0;i<5;i++){
        somaDP = somaDP + matriz[i][i];
        somaDS = somaDS + matriz[i][4-i];
    }
    for(i=0;i<5;i++){
        cout<<endl;
        for(j=0;j<5;j++){
            cout<<matriz[i][j]<<" ";
        }
    }
    cout<<"\n\nMedia da diagonal principal: "<<somaDP/5<<endl;
    cout<<"Media da diagonal secundaria: "<<somaDS/5;
    if((somaDP/5)==(somaDS/5)){
        cout<<"\nAs medias sao iguais!";
    } else{
        cout<<"\nAs medias sao diferentes!";
    }

    return 0;
}