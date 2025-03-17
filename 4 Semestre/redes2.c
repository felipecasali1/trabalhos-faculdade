#include<stdio.h>
#include<winsock2.h>
int main(int argc , char *argv[]){
    WSADATA winsock;
    SOCKET my_sock;
    struct sockaddr_in servidor;
    printf("\nIniciando Winsock…\n");
    if (WSAStartup(MAKEWORD(2,2),&winsock) != 0)
    {
        printf("A inicialização falhou, código do erro: %d\n",WSAGetLastError());
        return 1;
    }
    printf("Winsock Iniciado.\n");
    if((my_sock = socket(AF_INET , SOCK_STREAM , 0 )) == INVALID_SOCKET)
    {
        printf("Erro ao criar o socket: %d\n" , WSAGetLastError());
        return 1;
    }
    printf("Socket criado.\n");

    servidor.sin_addr.s_addr = inet_addr("200.199.220.120");
    servidor.sin_family = AF_INET;
    servidor.sin_port = 80;

   //Connect to remote server
    if (connect(my_sock , (struct sockaddr *)&servidor , sizeof(servidor)) < 0)
    {
        puts("A conexão não pode ser estabelecida :( \n");
        return 1;
    }

    puts("Conexão estabelecida :) \n");
    return 0;
}
