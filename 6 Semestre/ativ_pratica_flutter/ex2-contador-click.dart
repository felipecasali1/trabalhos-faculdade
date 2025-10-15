import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _App();
  }
}

class _App extends State<StatefulWidget> {
  int numero = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Column(
            children: [
              Text('Contador: '),
              Text("$numero"),
              ElevatedButton(
                onPressed: () => setState(() {
                  numero++;  
                }),
                child: Text('Click'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
