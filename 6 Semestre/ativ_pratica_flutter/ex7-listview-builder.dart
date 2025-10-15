import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListViewExample2();
  }
}

class ListViewExample2 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _ListViewExample2();
  }
}

class _ListViewExample2 extends State<ListViewExample2> {
  List<String> nomes = ['Felipe', 'Maria', 'Lucas', 'Ana', 'Paulo', 'Gabriela', 'José', 'Aline'];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: ListView.builder(
          itemCount: nomes.length,
          itemBuilder: (context, index) {
            ListTile(
              title: Text(nomes[index]),
            );
          },
        ),
      ),
    );
  }
}