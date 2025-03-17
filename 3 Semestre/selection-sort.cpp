#include <iostream>

int main(){
    int n, i, j, menor, aux;
    std::cout<<"Informe o tamanho da entrada: ";
    std::cin>>n;
    int v[n];

    std::cout<<"\n";
    for(i=0 ; i<n ; i++){
        std::cout<<"Informe a posição "<<i+1<<" do vetor: \n";
        std::cin>>v[i];
    }

    for(i=0 ; i<(n-1) ; i++){
        menor = i;
        for(j=(i+1) ; j<n ; ++j){
            if(v[j] < v[menor]){
                menor = j;
            }
        }
        aux = v[menor];
        v[menor] = v[i];
        v[i] = aux;
    }

    std::cout<<"\nVetor organizado:\n";
    for(i=0 ; i<n ; i++){
        std::cout<<v[i]<<" ";
    }
    return 0;
}