import 'package:ativ_cadastro_livros/features/presentation/screens/register_page.dart';
import 'package:flutter/material.dart';

class MyDrawer extends StatelessWidget {
 const MyDrawer({super.key});

 @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        children: [
          DrawerHeader(
            padding: EdgeInsets.fromLTRB(20, 40, 0, 0),
            child: Text(
              'My\nBooks',
              style: TextStyle(
                fontSize: 24,
                fontStyle: FontStyle.italic,
              ),
            ),
          ),
          ListTile(
            leading: Icon(Icons.home),
            title: Text('Página Inicial'),
            onTap: () {
              Navigator.pop(context);
            },
          ),
          ListTile(
            leading: Icon(Icons.book),
            title: Text('Cadastrar livro'),
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => RegisterPage()));
            },
          ),
        ],
      ),
    );
  } 
}