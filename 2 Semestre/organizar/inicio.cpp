#include <iostream>//biblioteca
using namespace std;//substitui o std::
int main(){
    char nome[20];
    cout<<"Hello World!"<<endl;
    //std::cout<<
    //(<<)seria o output, como um printf ou puts
    // <<endl seria o \n mas fora do " "
    cout<<"Qual seu nome? ";
    cin>>nome;
    //std::cin>>
    //(>>) seria o input, como scanf ou fgets
    //cin>> nao necessita tipagem

    cout<<"Seja bem-vindo "<<nome<<"!";
}