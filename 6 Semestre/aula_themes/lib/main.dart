import 'package:aula_themes/themes/app_theme.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: darkTheme,
      home: MyAppExample(),
    );
  }
}

class MyAppExample extends StatefulWidget {
  @override
  _MyAppExampleState createState() => _MyAppExampleState();
}

class _MyAppExampleState extends State<MyAppExample> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('MyFoodBusiness'),
      ),
      body: Column(
        children: [
          Padding(
            padding: EdgeInsetsGeometry.all(20), 
            child: Text('Lista de produtos'),
          ),
          ElevatedButton(onPressed: () {}, child: Text('Limpar')),
          Expanded(
            child: ListView(
              children: [
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
                ListTile(title: Text('Item')),
              ],
            ),
          ),
        ],
      ),
    );
  }
}