#include <stdio.h>
#include <winsock2.h> //add compilador da biblioteca MINGW\lib\libws2_32.a
int main(int argc , char *argv[]){
    WSADATA winsock;
    SOCKET my_sock;
    printf("\nIniciando Winsock…\n");
    if (WSAStartup(MAKEWORD(2,2),&winsock) != 0)
    {
        printf("A inicialização falhou, código do erro: %d\n",WSAGetLastError());
        return 1;
    }
    printf("Winsock Iniciado.\n");
    if((my_sock = socket(AF_INET , SOCK_STREAM , 6)) == INVALID_SOCKET)
    {
        printf("Erro ao criar o socket: %d\n" , WSAGetLastError());
        return 1;
    }
    printf("Socket criado.\n");

    closesocket(my_sock);
    WSACleanup();
    return 0;
}
