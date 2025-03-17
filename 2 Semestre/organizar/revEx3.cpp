#include <iostream>
#include <iomanip>
#include <locale.h>
using namespace std;
int main(){
    setlocale(LC_ALL, " ");
    float n1, n2, n3, mediaAluno, somaMedias;
    int i;
    somaMedias = 0;
    for(i=0;i<10;i++){
        cout<<"Aluno "<<i + 1<<endl;
        cout<<"Informe a primeira nota: ";
        cin>>n1;
        cout<<"Informe a segunda nota: ";
        cin>>n2;
        cout<<"Informe a terceira nota: ";
        cin>>n3;
        mediaAluno = (n1+n2+n3)/3;
        cout<<"A média é de: "<<fixed<<setprecision(2)<<mediaAluno<<endl<<endl;
        somaMedias = somaMedias + mediaAluno;
    }
    cout<<"A média da turma é de: "<<fixed<<setprecision(2)<<somaMedias/10;
    return 0;
}