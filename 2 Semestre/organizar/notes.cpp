#include <iostream>
using namespace std;
int main(){
    char matriz[10][10] = {
        {'f','e','l','i','p','e','\0'},
        {'f','e','l','i','p','e','\0'},
        {'f','e','l','i','p','e','\0'},
        {'f','e','l','i','p','e','\0'}
    };
    int i;
    for(i=0 ; i<5 ; i++){
        cout<<matriz[i]<<endl;  //printa a linha
    }
}