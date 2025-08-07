import 'dart:io';

void exercicio01() {
  try {
    double peso = 0, altura = 0;

    print("Informe seu peso: ");
    String? inputString = stdin.readLineSync();

    if (inputString != null && inputString.isNotEmpty) {
      peso = double.parse(inputString);
    }

    print("Informe sua altura: ");
    inputString = stdin.readLineSync();

    if (inputString != null && inputString.isNotEmpty) {
      altura = double.parse(inputString);
    }

    double imc = peso / (altura * altura);


    print("Seu IMC é: $imc");
    if (imc > 35) {
      print("Obesidade extrema!");
    } else if (imc > 30) {
      print("Obesidade!");
    } else if (imc > 25) {
      print("Excesso de peso!");
    } else if (imc > 18.5) {
      print("Peso normal!");
    } else {
      print("Abaixo do peso!");
    }
  } on Exception catch (e) {
    print("Entrada de dados inválida! $e");
  }
}

void exercicio02() {
  try {
    double tempCelsius = 0;
    print("Informe a temperatura em Celsius: ");

    String? inputString = stdin.readLineSync();

    if(inputString != null && inputString.isNotEmpty) {
      double tempFahrenheit = (tempCelsius * (9/5)) + 32;
      double tempKelvin = (tempCelsius + 273.15);
      print("A temperatura em Fahrenheit é: $tempFahrenheit");
      print("A temperatura em Kelvin é: $tempKelvin");
    } else {
      print("Temperatura inválida!");
    }

  } on Exception catch (e) {
    print("Temperatura inválida! $e");
  }
}

void exercicio03() {
  try {
    int numero = 0;
    print("Informe um número inteiro: ");
    String? inputString = stdin.readLineSync();

    if (inputString != null && inputString.isNotEmpty) {
      numero = int.parse(inputString);

      int count = 0;

      for (int i = numero; i > 0; i--) {
        if (numero % i == 0) {
          count++;
        }
      }

      count == 2 ? print("É primo!") : print("Não é primo!");
    } else {
      print("Número inválido!");
    }
  } on Exception catch (e) {
    print("Número inválido! $e");
  }
}

void exercicio04() {
  try {
    print("Digite uma frase:");
    String? inputString = stdin.readLineSync();

    if (inputString != null && inputString.isNotEmpty) {
      int count = 0, countChar = 0;
      List<String> vogais = ['a', 'e', 'i', 'o', 'u'];
      String invertedStr = "";
      
      for(int i = inputString.length - 1 ; i >= 0 ; i--) {
        if (vogais.contains(inputString[i].toLowerCase())) count++;

        if (inputString[i] != ' ') countChar++; 

        invertedStr += inputString[i];
      }
      
      print(inputString.length);
      print("\nA frase possui $countChar caracteres!");
      print("A frase invertida fica: $invertedStr");
      print("A frase possui $count vogais!");
    } else {
      print("Frase inválida!");
    }
  } on Exception catch (e) {
    print("Frase inválida! $e");
  }
}

void exercicio05() {
  try {
    int opt = 0;
    List<String> nomes = [];
    do {
      print("\n\nDigite 0 para sair!");
      print("Digite 1 para adicionar!");
      print("Digite 2 para remover!");
      print("Digite 3 para listar!");
      print("Digite 4 para buscar!");
      String? optString = stdin.readLineSync();
      if (optString != null && optString.isNotEmpty) opt = int.parse(optString);

      switch(opt) {
        case 0:
          break;
        case 1:
          print("\nInforme um nome: ");
          String? inputString = stdin.readLineSync();
          if (inputString != null && inputString.isNotEmpty) nomes.add(inputString);
          print("Nome adicionado!");
          break;
        case 2:
          if(nomes.isEmpty) {
            print("Nenhum nome foi adicionado!");
          } else {
            print("\nInforme um nome: ");
            String? inputString = stdin.readLineSync();
            if (nomes.contains(inputString)) {
              nomes.remove(inputString);
            } else {
              print("Nome não encontrado!");
            }
          }
          break;
        case 3:
          if(nomes.isEmpty) {
            print("Nenhum nome foi adicionado!");
          } else {
            print(nomes);
          }
          break;
        case 4:
          if(nomes.isEmpty) {
            print("Nenhum nome foi adicionado!");
          } else {
            print("\nInforme um nome: ");
            String? inputString = stdin.readLineSync();
            if (nomes.contains(inputString)) {
              print("Nome encontrado!");
            } else {
              print("Nome não encontrado!");
            }
          }
          break;
        default:
          print("Opção Inválida!");
          break;
      }
    } while (opt != 0);
  } on Exception catch (e) {
    print("Exceção: $e");
  }
}

void exercicio06() {
  try {
    int opt = 0;
    do {
      print("\n\nDigite 0 para sair!");
      print("Digite 1 para exibir a data atual!");
      print("Digite 2 para a saudação!");
      String? optString = stdin.readLineSync();
      if (optString != null && optString.isNotEmpty) opt = int.parse(optString);

      switch(opt) {
        case 0:
          break;
        case 1:
          DateTime data = DateTime.now();
          print("\nA data atual é: ${data.day}/${data.month}/${data.year}");
          break;
        case 2:
          DateTime data = DateTime.now();
          if (data.hour > 0 && data.hour < 6) {
            print("\nBoa madrugada! Agora são ${data.hour}:${data.minute}!");
          } else if (data.hour < 12) {
            print("\nBom dia! Agora são ${data.hour}:${data.minute}!");
          } else if (data.hour < 18) {
            print("\nBom tarde! Agora são ${data.hour}:${data.minute}!");
          } else {
            print("\nBoa noite! Agora são ${data.hour}:${data.minute}!");
          }
          break;
        default:
          print("Opção Inválida!");
          break;
      }
    } while (opt != 0);
  } on Exception catch (e) {
    print("Exceção: $e");
  }
}

void exercicio07() {
  int sum = 0;

  List<List<int>> matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ];

  for(int i = 0 ; i<matriz.length ; i++) {
    for (int j = 0 ; j<matriz[i].length ; j++) {
      sum += matriz[i][j];
    }
  }

  print("A soma dos números da matriz resulta em: $sum!");
}

void main() {
  exercicio01();
  exercicio02();
  exercicio03();
  exercicio04();
  exercicio05();
  exercicio06();
  exercicio07();
}