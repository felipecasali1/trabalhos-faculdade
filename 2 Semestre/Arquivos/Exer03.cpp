#include <stdio.h>
#include <iostream>
#include <string.h>
#include <stdlib.h>
using namespace std;

main( )
{
    FILE *arquivo1, *arquivo2;
    char registro[70], nome[30], cpf[15], rg[15], idade[5], escolaridade[15];
    int i, j;

    //Abrindo o arquivo em modo "somente leitura"
    arquivo1 = fopen("senso.txt", "r");

    //Criando o arquivo em modo "escrita"
    arquivo2 = fopen("superior.txt", "w");

    //Enquanto não for fim de arquivo o looping será executado
    while(fgets(registro, 70, arquivo1) != NULL)
    {
        i = j = 0;
        while(!isdigit(registro[i])) nome[j++] = registro[i++]; //Extraindo o nome
        nome[j-1] = '\0';

        j = 0;
        while(registro[i] != ' ') cpf[j++] = registro[i++]; //Extraindo o cpf
        cpf[j] = '\0';

        i++;
        j = 0;
        while(registro[i] != ' ') rg[j++] = registro[i++]; //Extraindo o rg
        rg[j] = '\0';

        i++;
        j = 0;
        while(registro[i] != ' ') idade[j++] = registro[i++]; //Extraindo a idade
        idade[j] = '\0';

        i++;
        j = 0;
        while(registro[i] != '\n') escolaridade[j++] = registro[i++]; //Extraindo o níver de escolaridade
        escolaridade[j] = '\0';

        if(!strcmp(strupr(escolaridade),"SUPERIOR")) //Escrevendo no arquivo de saída os dados dos habitantes de nível superior
             fprintf(arquivo2, "%s %s %s %s\n", nome, cpf, rg, idade);
    }

    //Fechando os arquivos
    fclose(arquivo1);
    fclose(arquivo2);
}
