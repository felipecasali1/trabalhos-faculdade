#include <iostream>

void intercala(int v[], int p, int q, int r){
    int tam = r-p+1;
    int temp[tam];
    int i=p, j=q+1, k=0;

    while(i <= q && j <= r){
        if(v[i] <= v[j]){
            temp[k++] = v[i++];
        } else{
            temp[k++] = v[j++];
        }
    }

    while (i <= q){
        temp[k++] = v[i++];
    }
    while (j <= r){
        temp[k++] = v[j++];
    }

    for (int i = 0; i < tam; i++){
        v[p + i] = temp[i];
    }
}
//p = inicio, r = fim e q = meio
void mergeSort(int v[], int p, int r){
    int q;
    if(p<r){
        q = (p+r)/2;
        mergeSort(v, p, q);
        mergeSort(v, q+1, r);
        intercala(v, p, q, r);
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

    mergeSort(v, 0, n-1);
    std::cout<<"\nVetor organizado:\n";
    for(i=0 ; i<n ; i++){
        std::cout<<v[i]<<" ";
    }
    return 0;
}