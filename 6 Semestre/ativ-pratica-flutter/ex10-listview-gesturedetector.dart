import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return NotesApp();
  }
}

class NotesApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _NotesApp();
  }
}

class _NotesApp extends State<NotesApp> {
  final _noteController = TextEditingController();
  List<String> notes = [];

  @override
  void dispose() {
    _noteController.dispose();
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
                Container(
                  child: TextField(
                    controller: _noteController,
                    keyboardType: TextInputType.text,
                    decoration: InputDecoration(
                      hint: Text('Nova anotação...')
                    ),
                  ),
                ),
                Container(
                  child: ElevatedButton(
                    onPressed: () {
                      setState(() {
                        notes.add(_noteController.text);
                        _noteController.clear();
                      });
                    },
                    child: Text('Adicionar')
                  ),
                ),
                Expanded(
                  child: ListView.builder(
                    itemCount: notes.length,
                    itemBuilder: (context, index) {
                      return GestureDetector(
                        onTap: () {
                          setState(() {
                            notes.removeAt(index);
                          });
                        },
                        child: ListTile(
                          title: Text(notes[index]),
                        ),
                      ); 
                    },
                ),
                ),
              ],
            );
          } 
        ), 
      ),
    );
  }
}