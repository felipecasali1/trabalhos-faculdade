import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: FormExample());
  }
}

class FormExample extends StatefulWidget {
  @override
  _FormExampleState createState() => _FormExampleState();
}

class _FormExampleState extends State<FormExample> {
  // Chave para identificar e controlar o formulário.
  final _formKey = GlobalKey<FormState>();
  // Controlador para ler o valor do campo de texto.
  final _nameController = TextEditingController();
  final _ageController = TextEditingController();
  final _emailController = TextEditingController();
  final _cityController = TextEditingController();

  String? _message;

  @override
  void dispose() {
    // Libera os recursos do controller para evitar vazamentos de memória.
    _nameController.dispose();
    _ageController.dispose();
    _emailController.dispose();
    _cityController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Formulário')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Form(
          key: _formKey, // Associa a chave ao formulário.
          child: Column(
            children: [
              TextFormField(
                controller: _nameController,
                decoration: InputDecoration(labelText: 'Nome'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Digite seu nome';
                  }
                  return null;
                },
              ),
              TextFormField(
                keyboardType: TextInputType.number,
                controller: _ageController,
                decoration: InputDecoration(labelText: 'Idade'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Digite sua idade';
                  }

                  int? parsedValue = int.tryParse(value);
                  if (parsedValue == null || parsedValue < 1) {
                    return 'Idade inválida';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _emailController,
                decoration: InputDecoration(labelText: 'E-mail'),
                validator: (value) {
                  if (value == null || value.isEmpty || !value.contains('@')) {
                    return 'Digite seu E-mail';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _cityController,
                decoration: InputDecoration(labelText: 'Cidade'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Digite sua cidade';
                  }
                  return null;
                },
              ),
              SizedBox(height: 20), // Apenas um espaço vertical.
              ElevatedButton(
                onPressed: () {
                  // Verifica se o formulário é válido.
                  if (_formKey.currentState!.validate()) {
                    setState(() {
                      _message = '${_nameController.text}, você tem ${_ageController.text} anos, mora em ${_cityController.text} e seu e-mail é ${_emailController.text}!';
                    });


                    // Se for válido, exibe um SnackBar com o nome.
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(content: Text(
                        'Cadastro realizado!'
                      )),
                    );
                  }
                },
                child: Text('Enviar'),
              ),
              if (_message != null) Text(_message!),
            ],
          ),
        ),
      ),
    );
  }
}