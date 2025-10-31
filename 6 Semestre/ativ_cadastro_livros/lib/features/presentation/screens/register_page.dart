import 'package:ativ_cadastro_livros/features/data/dao/book_dao.dart';
import 'package:ativ_cadastro_livros/features/data/models/book.dart';
import 'package:flutter/material.dart';

class RegisterPage extends StatefulWidget {
  const RegisterPage({super.key});

  @override
  State<RegisterPage> createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  final _formKey = GlobalKey<FormState>();
  final _titleController = TextEditingController();
  final _authorController = TextEditingController();
  final _yearController = TextEditingController();
  final _publisherController = TextEditingController();

  final _bookDao = BookDAO();

  void _saveBook() async {
    if (_formKey.currentState!.validate()) {
      final book = Book(
        title: _titleController.text,
        author: _authorController.text,
        publicationYear: int.parse(_yearController.text),
        publisher: _publisherController.text,
      );

      await _bookDao.addBook(book);

      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Livro cadastrado com sucesso!')),
      );

      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Cadastrar Livro')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _titleController,
                decoration: const InputDecoration(labelText: 'Título'),
                validator: (value) =>
                    value == null || value.isEmpty ? 'Informe o título' : null,
              ),
              const SizedBox(height: 12),
              TextFormField(
                controller: _authorController,
                decoration: const InputDecoration(labelText: 'Autor'),
                validator: (value) =>
                    value == null || value.isEmpty ? 'Informe o autor' : null,
              ),
              const SizedBox(height: 12),
              TextFormField(
                controller: _yearController,
                decoration:
                    const InputDecoration(labelText: 'Ano de publicação'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Informe o ano';
                  }
                  if (int.tryParse(value) == null) {
                    return 'Ano inválido';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 12),
              TextFormField(
                controller: _publisherController,
                decoration: const InputDecoration(labelText: 'Editora'),
                validator: (value) =>
                    value == null || value.isEmpty ? 'Informe a editora' : null,
              ),
              const SizedBox(height: 24),
              ElevatedButton(
                onPressed: _saveBook,
                child: const Text('Salvar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}