#include <iostream>

void criarHeap(int v[], int n, int i){
    int maior, esq, dir, aux;
    maior = i;
    esq = (2*i) + 1;
    dir = (2*i) + 2;

    if(esq < n && v[esq] > v[maior]){
        maior = esq;
    }

    if(dir < n && v[dir] > v[maior]){
        maior = dir;
    }

    if(maior != i){
        aux = v[i];
        v[i] = v[maior];
        v[maior] = aux;

        criarHeap(v, n, maior);
    }
}

void heapSort(int v[], int n){
    int i, aux;
    for(i = n/2-1 ; i>=0 ; i--){
        criarHeap(v, n, i);
    }
    for(i=n-1 ; i>0 ; i--){
        aux = v[i];
        v[i] = v[0];
        v[0] = aux;

        criarHeap(v, i, 0);
    }
}

int main(){
    int n, i, j;
    std::cout<<"Informe o tamanho da entrada: ";
    std::cin>>n;
    int v[n];

    std::cout<<"\n";
    for(i=0 ; i<n ; i++){
        std::cout<<"Informe a posição "<<i+1<<" do vetor: \n";
        std::cin>>v[i];
    }

    heapSort(v, n);

    std::cout<<"\nVetor organizado:\n";
    for(i=0 ; i<n ; i++){
        std::cout<<v[i]<<" ";
    }
    return 0;
}