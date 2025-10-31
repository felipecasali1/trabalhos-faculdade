import 'package:ativ_cadastro_livros/features/data/dao/book_dao.dart';
import 'package:ativ_cadastro_livros/features/data/models/book.dart';
import 'package:ativ_cadastro_livros/features/presentation/screens/register_page.dart';
import 'package:ativ_cadastro_livros/features/presentation/widgets/appbar.dart';
import 'package:ativ_cadastro_livros/features/presentation/widgets/drawer.dart';
import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final BookDAO _bookDao = BookDAO();

  @override
  Widget build(BuildContext context) {
    final box = Hive.box<Book>(BookDAO.boxName);
    
    return Scaffold(
      appBar: buildAppBar(context),
      drawer: MyDrawer(),
      body: ValueListenableBuilder(
        valueListenable: box.listenable(),
        builder: (context, Box<Book> booksBox, _) {
          final books = booksBox.values.toList();

          if (books.isEmpty) {
            return const Center(child: Text('Nenhum livro cadastrado.'));
          }

          return ListView.builder(
            itemCount: books.length,
            itemBuilder: (context, index) {
              final book = books[index];

              return ListTile(
                title: Text(book.title),
                subtitle:
                    Text('Autor: ${book.author}\nPublicado em ${book.publicationYear.toString()}\nEditora: ${book.publisher}'),
                trailing: IconButton(
                  icon: const Icon(Icons.delete, color: Colors.black),
                  onPressed: () async {
                    await _bookDao.deleteBook(index);
                  },
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.blue,
        
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (_) => const RegisterPage()),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}