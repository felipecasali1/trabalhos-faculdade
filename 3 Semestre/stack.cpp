#include <iostream>

void empilhar(int p[], int &topo, int x, int n){
    if (topo >= (n-1)) {
        std::cout<<"\nA pilha esta cheia!\n";
    } else{
        topo++;
        p[topo] = x;
        std::cout<<"\n "<<x<<" foi adicionado!\n";
    }
}

void retirar(int p[], int &topo){
    if (topo < 0) {
        std::cout<<"\nPilha vazia!\n";
    }
    else {
        topo--;
        std::cout<<"\n"<<p[topo+1]<<" retirado!\n";
    }
}

int main(){
    int n, topo = -1, option, x, i;
    std::cout<<"Informe o tamanho da pilha: ";
    std::cin>>n;
    int p[n];

    do{
        std::cout<<"\n[1] para empilhar";
        std::cout<<"\n[2] para retirar";
        std::cout<<"\n[3] para visualizar";
        std::cout<<"\n[0] para sair\n";
        std::cin>>option;
        switch (option){
            case 0:
                std::cout<<"\nPrograma finalizado!";
            break;
            case 1:
                std::cout<<"\nInforme o numero a ser empilhado: ";
                std::cin>>x;
                empilhar(p, topo, x, n);
            break;
            case 2:
                retirar(p, topo);
            break;
            case 3:
                std::cout<<"\nPilha: ";
                for(i=topo ; i>=0 ; i--){
                    std::cout<<"\n"<<p[i];
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