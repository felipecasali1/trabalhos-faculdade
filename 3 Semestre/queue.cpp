#include <iostream>

void enfileirar(int f[], int x, int n, int &ini, int &fim){
    if(fim == n){
        fim = 0;
    }
    if((ini == fim+1) || ((fim+1 == n) && ini == 0)){
        std::cout<<"\nA fila esta cheia!\n";
    } else{
        f[fim] = x;
        std::cout<<"\n"<<x<<" enfileirado!\n";
        fim++;
    }
}

void desenfileirar(int f[], int n, int &ini, int &fim){
    if(ini == fim){
        std::cout<<"\nA fila esta vazia!\n";
    } else{
        int num = f[ini];
        if(ini == n){
            ini = 0;
        } else{
            ini++;
        }
        std::cout<<"\n"<<num<<" foi retirado!\n";
    }
}

int main(){
    int n, option, x, ini = 0, fim = 0, i;
    std::cout<<"Informe o tamanho da fila: ";
    std::cin>>n;
    n += 1;
    int f[n];

    do{
        std::cout<<"\n[1] para enfileirar";
        std::cout<<"\n[2] para desenfileirar";
        std::cout<<"\n[3] para visualizar";
        std::cout<<"\n[0] para sair\n";
        std::cin>>option;
        switch (option){
            case 0:
                std::cout<<"\nPrograma finalizado!";
            break;
            case 1:
                std::cout<<"\nInforme o numero a ser enfileirado: ";
                std::cin>>x;
                enfileirar(f, x, n, ini, fim);
            break;
            case 2:
                desenfileirar(f, n, ini, fim);
            break;
            case 3:
                std::cout<<"\nFila: ";
                if(ini <= fim){
                    for(i=ini ; i<fim ; i++){
                        std::cout<<"\n"<<f[i];
                    }
                } else {
                    for(i=ini ; i<n ; i++){
                        std::cout<<"\n"<<f[i];
                    }
                    for(i=0 ; i<fim ; i++){
                        std::cout<<"\n"<<f[i];
                    }
                }
                std::cout<<"\n";
            break;
            default:
                std::cout<<"\nOpcao invalida!";
            break;
        }
    } while(option!=0);
    return 0;
}