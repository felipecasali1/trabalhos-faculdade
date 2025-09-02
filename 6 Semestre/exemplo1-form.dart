import 'package:flutter/material.dart';  // Importa a biblioteca do Flutter para usar widgets e funcionalidades como MaterialApp, Scaffold, etc.

void main() => runApp(App());  // Função principal que chama o método runApp() para rodar o aplicativo. Passa o widget App como parâmetro.

class App extends StatefulWidget {  // Define o widget App como um StatefulWidget, o que significa que ele tem um estado mutável.
  @override
  State<StatefulWidget> createState() {  // Sobrescreve o método createState(), que cria o estado da tela.
    return _App();  // Retorna o estado (_App), que é uma instância de _App.
  }
}

class _App extends State<App> {  // Define a classe _App que gerencia o estado da aplicação.
  var texto;  // Declara uma variável para armazenar o texto digitado pelo usuário.
  var _controle = TextEditingController();  // Cria um controlador para o TextFormField, que irá controlar o texto digitado.
  var _keyForm = GlobalKey<FormState>();  // Cria uma chave global para o formulário, usada para validar o formulário.

  @override
  Widget build(BuildContext context) {  // Sobrescreve o método build() para construir a interface do usuário.
    return MaterialApp(  // Retorna o MaterialApp, que é o widget principal da aplicação (contém a estrutura visual do app).
      home: Scaffold(  // O Scaffold fornece a estrutura básica para o app, incluindo a AppBar, corpo, botões, etc.
        body: Form(  // O widget Form envolve os campos do formulário, permitindo validação e manipulação de estado.
          key: _keyForm,  // Atribui a chave global do formulário.
          child: Column(  // Organiza os widgets filhos de forma vertical (em uma coluna).
            children: [  // Lista de widgets dentro da coluna.
              Text('Cadastro de nome'),  // Exibe um título informativo na tela.
              TextFormField(  // Um campo de texto que valida a entrada do usuário.
                controller: _controle,  // Atribui o controlador (_controle) ao TextFormField para controlar o texto inserido.
                validator: (value) {  // Função de validação do campo. Verifica se o campo está vazio.
                  if (value == null || value.isEmpty) {  // Se o campo estiver vazio...
                    return "Deu erro informe um valor";  // Retorna uma mensagem de erro.
                  }
                  return null;  // Se o campo não estiver vazio, retorna null (sem erro).
                },
              ),
              ElevatedButton(  // Cria um botão elevado.
                onPressed: () {  // Define o que acontece quando o botão é pressionado.
                  if (_keyForm.currentState!.validate()) {  // Verifica se o formulário é válido.
                    setState(() {  // Chama o setState() para atualizar a interface.
                      texto = _controle.text;  // Atribui o texto digitado ao valor da variável 'texto'.
                      _controle.clear();  // Limpa o campo de texto após o envio.
                    });
                  }
                },
                child: Text('Click'),  // O texto exibido no botão.
              ),
              Text('Voce digitou $texto'),  // Exibe o texto digitado pelo usuário, após o clique no botão.
            ],
          ),
        ),
      ),
    );
  }

  @override
  void dispose() {  // Sobrescreve o método dispose() para liberar os recursos quando o widget for removido.
    _controle.dispose();  // Libera os recursos utilizados pelo controlador (_controle).
    super.dispose();  // Chama o método dispose() da classe pai (State), garantindo a liberação adequada de recursos.
  }
}