import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _App();
  }
}

class _App extends State<App> {
  var name;
  var _nameController = TextEditingController();

  @override
  void dispose() {
    _nameController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Builder(
          builder: (context) {
            return Column(
              children: [
                TextField(
                  controller: _nameController,
                  keyboardType: TextInputType.name,
                ),
                ElevatedButton(
                  onPressed: () {
                    name = _nameController.text;
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text('O seu nome é ${_nameController.text}'),
                        duration: Duration(seconds: 2),
                      ),
                    );
                    _nameController.clear();
                  },
                  child: Text('Salvar')),
              ],
            );
          } 
        ),
      ),
    );
  }
}
