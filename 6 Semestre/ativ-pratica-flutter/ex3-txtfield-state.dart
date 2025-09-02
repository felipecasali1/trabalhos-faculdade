import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _App();
  }
}

class _App extends State<StatefulWidget> {
  var name;
  var _nameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Column(
            children: [
              TextField(
                controller: _nameController,
                keyboardType: TextInputType.name,
              ),
              ElevatedButton(
                onPressed: () {
                  name = _nameController.text;
                  print(name);
                  _nameController.clear();
                },
                child: Text('Salvar')),
            ],
          ),
        ),
      ),
    );
  }
}