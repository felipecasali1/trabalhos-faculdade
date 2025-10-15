import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListViewExample3();
  }
}

class ListViewExample3 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _ListViewExample3();
  }
}

class _ListViewExample3 extends State<ListViewExample3> {
  List<String> links = [
    'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/960px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg',
    'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/330px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg',
    'https://upload.wikimedia.org/wikipedia/pt/5/59/A_Persist%C3%AAncia_da_Mem%C3%B3ria.jpg',
    'https://upload.wikimedia.org/wikipedia/pt/thumb/b/bd/Abaporu.jpg/330px-Abaporu.jpg',
    'https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Leonardo_da_Vinci_%281452-1519%29_-_The_Last_Supper_%281495-1498%29.jpg/1200px-Leonardo_da_Vinci_%281452-1519%29_-_The_Last_Supper_%281495-1498%29.jpg'
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: ListView.builder(
          scrollDirection: Axis.horizontal,
          itemCount: links.length,
          itemBuilder: (context, index) {
            return Padding(
              padding: EdgeInsets.all(50.0),
              child: Container(
                height: 1000,
                width: 1000,
                child: Image.network(
                  links[index], 
                  fit: BoxFit.contain,
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}