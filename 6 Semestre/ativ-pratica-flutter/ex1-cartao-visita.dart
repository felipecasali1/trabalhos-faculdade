import 'package:flutter/material.dart';

void main() => (runApp(App()));

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: Scaffold(
      appBar: AppBar(
        title: Text('Meu Cartão de Visitas'),
      ),
      body: Center(
        child: Container(
          margin: EdgeInsets.all(200),

          child: Column(
            children: [
              Text('Felipe Casali', style: TextStyle(
                color: Colors.red,
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),),
              SizedBox(height: 25,),
              Text('Acadêmico de Engenharia de Software', style: TextStyle(
                fontSize: 16,
              ),),
              SizedBox(height: 10,),
              Text('E-mail: 802.483@alunos.unigran.br', style: TextStyle(
                fontSize: 16,
              ),),
            ],
          ),
        ),
      ),
    ),);
  }
}
