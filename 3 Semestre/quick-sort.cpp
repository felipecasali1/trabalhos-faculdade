#include <iostream>

int particao(int v[], int ini, int fim){
    int pivo = v[fim];
    int i = ini - 1;
    int aux, j;

    for (j = ini; j < fim; j++){
        if (v[j] <= pivo) {
            i++;
            aux = v[i];
            v[i] = v[j];
            v[j] = aux;
        }
    }

    aux = v[i + 1];
    v[i + 1] = v[fim];
    v[fim] = aux;

    return i + 1;
}
 
void quickSort(int v[], int ini, int fim){
    if (ini < fim) {
        int p;
        p = particao(v, ini, fim);
        quickSort(v, ini, p - 1);
        quickSort(v, p + 1, fim);
    }
}

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

    quickSort(v, 0, n - 1);
    std::cout<<"\nVetor organizado:\n";
    for(i=0 ; i<n ; i++){
        std::cout<<v[i]<<" ";
    }
    return 0;
}