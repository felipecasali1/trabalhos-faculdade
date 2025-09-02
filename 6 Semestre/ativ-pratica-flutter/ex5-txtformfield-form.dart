import 'package:flutter/material.dart';

void main() => runApp(App());

class App extends StatelessWidget {
    @override
  Widget build(BuildContext context) {
    return SimpleForm();
  }
}

class SimpleForm extends StatefulWidget {
    @override
  State<StatefulWidget> createState() {
    return _FormState();
  }
}

class _FormState extends State<SimpleForm> {
    final _formKey = GlobalKey<FormState>();
    final _nameController = TextEditingController();
    final _emailController = TextEditingController();

    @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            body: Form(
                key: _formKey,
                child: Column(
                    children: [
                        TextFormField(
                            decoration: InputDecoration(
                                labelText: 'Nome',
                            ),
                            controller: _nameController,
                            keyboardType: TextInputType.text,
                            validator: (value) {
                                if (value == null || value.isEmpty ) {
                                    return 'Digite seu nome';
                                }
                                return null;
                            },
                        ),
                        TextFormField(
                            decoration: InputDecoration(
                                labelText: 'E-mail',
                            ),
                            controller: _emailController,
                            keyboardType: TextInputType.emailAddress,
                            validator: (value) {
                                if (value == null || value.isEmpty ) {
                                    return 'Digite seu e-mail';
                                }
                                return null;
                            },
                        ),
                        ElevatedButton(
                            onPressed: () {
                                if (_formKey.currentState!.validate()) {
                                    print('Dados válidos!');
                                }
                            }, 
                            child: Text('Salvar'),
                        ),
                    ],
                ),
            ),
        ),
    );
  }
}