import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatelessWidget {
    @override
  Widget build(BuildContext context) {
    return ListViewExample();
  }
}

class ListViewExample extends StatefulWidget {
    @override
  State<StatefulWidget> createState() {
    return _ListViewExample();
  }
}

class _ListViewExample extends State<ListViewExample> {
    @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            body: ListView(
              children: [
                  ListTile(
                    title: Text('Maçã'),
                  ),
                  ListTile(
                    title: Text('Banana'),
                  ),
                  ListTile(
                    title: Text('Melancia'),
                  ),
                  ListTile(
                    title: Text('Pera'),
                  ),
                  ListTile(
                    title: Text('Goiaba'),
                  ),
                  ListTile(
                    title: Text('Abacaxi'),
                  ),
                  ListTile(
                    title: Text('Maçã'),
                  ),
                  ListTile(
                    title: Text('Banana'),
                  ),
                  ListTile(
                    title: Text('Melancia'),
                  ),
                  ListTile(
                    title: Text('Pera'),
                  ),
                  ListTile(
                    title: Text('Goiaba'),
                  ),
                  ListTile(
                    title: Text('Abacaxi'),
                  ),
                  ListTile(
                    title: Text('Maçã'),
                  ),
                  ListTile(
                    title: Text('Banana'),
                  ),
                  ListTile(
                    title: Text('Melancia'),
                  ),
                  ListTile(
                    title: Text('Pera'),
                  ),
                  ListTile(
                    title: Text('Goiaba'),
                  ),
                  ListTile(
                    title: Text('Abacaxi'),
                  ),
                  ListTile(
                    title: Text('Maçã'),
                  ),
                  ListTile(
                    title: Text('Banana'),
                  ),
                  ListTile(
                    title: Text('Melancia'),
                  ),
                  ListTile(
                    title: Text('Pera'),
                  ),
                  ListTile(
                    title: Text('Goiaba'),
                  ),
                  ListTile(
                    title: Text('Abóbora'),
                  ),
              ],
            ),
        ),
    );
  }
}