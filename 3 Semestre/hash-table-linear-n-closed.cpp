#include <iostream>
#include <stdlib.h>
using namespace std;

// Lista Encadeada
typedef int item;
typedef struct no{
    item info;
    struct no *prox;
} tplista;

tplista* alocar(){
    tplista* pt = (tplista*) malloc(sizeof(tplista));
    return pt;
}

// Declaracao global
const int numEntradas = 13;
tplista* enderFechado[numEntradas];
int abertoLinear[numEntradas];
bool ocupado[numEntradas];
int colisoesEnderFechado = 0;
int colisoesAbertoLinear = 0;
int compEnderFechado = 0;
int compAbertoLinear = 0;

// Inicalizacao e calculo de chave
void inicializarTabelas(){
    for(int i=0; i<numEntradas; i++){
        enderFechado[i] = NULL;
        abertoLinear[i] = -1;
        ocupado[i] = false;
    }
}

int funcaoHash(int chave){
    return chave % numEntradas;
}

// Inserir - Lista, End. Fechado e End. Aberto Linear
void inserirLista(tplista **lista, item info){
    tplista *novoNo = alocar();

    if(novoNo == NULL){
        cout<<"\nErro ao alocar memoria!";
    }
    novoNo->info = info;
    novoNo->prox = *lista;
    *lista = novoNo;
}

void inserirEnderFechado(int chave){
    int index = funcaoHash(chave);
    if(enderFechado[index] != NULL){
        colisoesEnderFechado++;
    }
    inserirLista(&enderFechado[index], chave);
}

void inserirAbertoLinear(int chave){
    int index = funcaoHash(chave);

    while(ocupado[index]){
        colisoesAbertoLinear++;
        index = (index+1) % numEntradas;
    }
    abertoLinear[index] = chave;
    ocupado[index] = true;
}

void inserir(int chave){
    inserirEnderFechado(chave);
    inserirAbertoLinear(chave);
    cout<<"Colisoes no enderecamento fechado: "<<colisoesEnderFechado<<endl;
    cout<<"Colisoes no enderecamento aberto linear: "<<colisoesAbertoLinear<<endl;
}

// Remover - Lista, End. Fechado e End. Aberto Linear
void removerLista(tplista **lista, item valor){
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

void removerEnderFechado(int chave){
    int index = funcaoHash(chave);
    removerLista(&enderFechado[index], chave);
    cout<<"Enderecamento Fechado: Valor removido!"<<endl;
}

void removerAbertoLinear(int chave){
    int index = funcaoHash(chave);
    while(ocupado[index]){
        if(abertoLinear[index] == chave){
            abertoLinear[index] = -1;
            ocupado[index] = false;
            cout<<"Enderecamento Aberto Linear: Valor removido!"<<endl;
            return;
        }
        index = (index+1) % numEntradas;
    }
    cout<<"Enderecamento Aberto Linear: Valor nao encontrado!"<<endl;
}

void remover(int chave){
    removerEnderFechado(chave);
    removerAbertoLinear(chave);
}

// Buscar - End. Fechado e End. Aberto Linear
bool buscarEnderFechado(int chave){
    int index = funcaoHash(chave);
    compEnderFechado = 0;
    tplista* atual = enderFechado[index];

    while(atual != NULL){
        compEnderFechado++;
        if(atual->info == chave){
            return true;
        }
        atual = atual->prox;
    }
    return false;
}

bool buscarAbertoLinear(int chave){
    int index = funcaoHash(chave);
    compAbertoLinear = 0;
    while(ocupado[index]){
        compAbertoLinear++;
        if(abertoLinear[index] == chave){
            return true;
        }
        index = (index + 1) % numEntradas;
    }
    return false;
}

void buscar(int chave){
    bool encontradoEF = buscarEnderFechado(chave);
    bool encontradoAL = buscarAbertoLinear(chave);

    cout<<"Comparacoes Enderecamento Fechado: "<<compEnderFechado<<endl;
    cout<<"Comparacoes Enderecamento Aberto Linear: "<<compAbertoLinear<<endl;
    if(encontradoEF || encontradoAL){
        cout<<"Valor encontrado!"<<endl;
    } else{
        cout<<"Valor não encontrado!"<<endl;
    }
}

// Exibir - Lista, End. Fechado e End. Aberto Linear
void exibirLista(tplista *lista){
    tplista *atual = lista;
    while(atual != NULL){
        cout<<"["<<atual->info<<"] -> ";
        atual = atual->prox;
    }
    cout<<"[NULL]\n";
}

void exibirEnderFechado(){
    cout<<"\n";
    for(int i = 0; i < numEntradas; ++i){
        cout<<i<<". ";
        exibirLista(enderFechado[i]);
    }
}

void exibirAbertoLinear(){
    cout<<"\n";
    for(int i = 0; i < numEntradas; ++i){
        cout<<i<<". [";
        if(ocupado[i]){
            cout<<abertoLinear[i]<<"]"<<endl;
        } else{
            cout<<"NULL]"<<endl;
        }
    }
}

// Desalocar Listas Encadeadas
void desalocarLista(tplista **lista){
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
    inicializarTabelas();
    int opcao, valor;

    do{
        cout<<"\nMENU\n";
        cout<<"1 - Inserir\n";
        cout<<"2 - Buscar\n";
        cout<<"3 - Remover\n";
        cout<<"4 - Visualizar\n";
        cout<<"0 - Sair\n";
        cout<<"Escolha uma opcao: ";
        cin>>opcao;

        switch(opcao){
            case 0:
                for(int i = 0; i < numEntradas; i++){
                    desalocarLista(&enderFechado[i]);
                }
                cout<<"\nEncerrando o programa e desalocando as listas...";
                break;
            case 1:
                cout<<"\nInforme o valor a ser inserido: ";
                cin>>valor;
                inserir(valor);
                break;
            case 2:
                cout<<"\nInforme o valor a ser buscado: ";
                cin>>valor;
                buscar(valor);
                break;
            case 3:
                cout<<"\nInforme um valor para remover: ";
                cin>>valor;
                remover(valor);
                break;
            case 4:
                int subopcao;
                cout<<"\n1 - Visualizar End. Fechado";
                cout<<"\n2 - Vizualizar End. Aberto Linear";
                cout<<"\nEscolha uma opcao: ";
                cin>>subopcao;

                if(subopcao == 1){
                    exibirEnderFechado();
                } else if(subopcao == 2){
                    exibirAbertoLinear();
                } else{
                    cout<<"Opcao invalida!"<<endl;
                }
                break;
            default:
                cout<<"\nOpcao invalida!";
                opcao = 5;
                break;
        }
    } while(opcao != 0);
    return 0;
}