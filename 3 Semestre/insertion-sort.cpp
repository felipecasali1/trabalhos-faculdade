#include <iostream>

int main(){
    int arr[5] = {6,3,7,9,4};
    int aux, j = 0, n = 5;

    //INSERTION SORT
    for(int i = 1 ; i<n ; i++){
        aux = arr[i];
        j = i-1;

        while(j >= 0 && arr[j] > aux){
            arr[j+1] = arr[j];
            --j;
        }
        arr[j+1] = aux;
    }

    for(int i = 0 ; i<n ; i++){
        std::cout<<arr[i]<<" ";
    }
    return 0;
}
