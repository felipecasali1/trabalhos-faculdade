#include <iostream>
using namespace std;
struct Aluno {
    int matricula;
    float nota[3];
    float media;
    char nome[26];
};
int main(){
    Aluno lista[100];
    int n, i;
    do{
        cout<<"Digite a quantidade de alunos: ";
        cin>>n;
        if(n<=0||n>100){
            cout<<"O valor deve ser positivo e <= 100!"<<endl;
        }
    }while(n<=0||n>100);
    for(i=0 ; i<n ; i++){
        cout<<"\nInforme o numero da matricula do aluno: ";
        cin>>lista[i].matricula;
        lista[i].media = 0;
        for(int j=0 ; j<3 ; j++){
            cout<<"Entre com a nota "<<j+1<<" do aluno: ";
            cin>>lista[i].nota[j];
            lista[i].media += lista[i].nota[j];
        }
        lista[i].media /= 3;
        cout<<"Entre com o nome do aluno: ";
        _flushall();
        gets(lista[i].nome);
    }
    for(i=0 ; i<n ; i++){
        cout<<"\nDados do aluno "<<i+1<<endl;
        cout<<"Nome: "<<lista[i].nome<<endl;
        cout<<"Matricula: "<<lista[i].matricula<<endl;
        cout<<"Nota 1: "<<lista[i].nota[0]<<endl;
        cout<<"Nota 2: "<<lista[i].nota[1]<<endl;
        cout<<"Nota 3: "<<lista[i].nota[2]<<endl;
        cout<<"Media: "<<lista[i].media<<endl;
    }
}