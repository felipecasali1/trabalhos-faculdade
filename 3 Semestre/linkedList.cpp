#include <iostream>
#include <stdlib.h>

typedef int item;

typedef struct no{
    item info;
    struct no *prox;
}tplista;

tplista* aloca(){
    tplista* pt;
    pt = (tplista*) malloc(sizeof(tplista));
    return pt;
}

void inserir(tplista **lista, item info){
    tplista *novoNo = aloca();
    if(novoNo == NULL){
        std::cout<<"\nErro ao alocar memoria!";
    }

    novoNo->info = info;
    novoNo->prox = *lista;
    *lista = novoNo;
}

bool busca(tplista *lista, item valor){
    tplista *atual = lista;

    while(atual != NULL){
        if(atual->info == valor){
            return true;
        }
        atual = atual->prox;
    }
    return false;
}

void remover(tplista **lista, item valor){
    tplista *temp = *lista;
    tplista *anterior = NULL;

    if(temp != NULL && temp->info == valor){
        *lista = temp->prox;
        free(temp);
        return;
    }

    while(temp != NULL && temp->info != valor){
        anterior = temp;
        temp = temp->prox;
    }
    
    if(temp == NULL){
        return;
    }

    anterior->prox = temp->prox;
    free(temp);
}

void exibir(tplista *lista){
    tplista *atual = lista;
    std::cout<<"\n";
    while(atual != NULL){
        std::cout<<atual->info<<" -> ";
        atual = atual->prox;
    }
    std::cout<<"NULL\n";
}

void desalocar(tplista **lista){
    tplista *atual = *lista;
    tplista *proximo = NULL;

    while(atual != NULL){
        proximo = atual->prox;
        free(atual);
        atual = proximo;
    }

    *lista = NULL;
}

int main(){
    tplista *lista = NULL;

    int opcao, valor;

    do{
        std::cout<<"\nMENU\n";
        std::cout<<"1 - Inserir no inicio\n";
        std::cout<<"2 - Buscar\n";
        std::cout<<"3 - Remover\n";
        std::cout<<"0 - Sair\n";
        std::cout<<"Escolha uma opcao: ";
        std::cin>>opcao;

        switch(opcao){
            case 0:
                desalocar(&lista);
                std::cout<<"\nEncerrando o programa e desalocando a lista...";
            break;
            case 1:
                std::cout<<"\nInforme o valor a ser inserido: ";
                std::cin>>valor;
                inserir(&lista, valor);
                exibir(lista);
            break;
            case 2:
                std::cout<<"\nInforme o valor a ser buscado: ";
                std::cin>>valor;
                if(busca(lista, valor)){
                    std::cout<<"\nValor encontrado na lista!";
                } else {
                    std::cout<<"\nValor não encontrado!";
                }
                exibir(lista);
            break;
            case 3:
                std::cout<<"\nInforme um valor para remover: ";
                std::cin>>valor;
                remover(&lista, valor);
                exibir(lista);
            break;
            default:
                std::cout<<"\nOpcao invalida!";
                opcao = 4;
            break;
        }
    } while(opcao != 0);
    return 0;
}