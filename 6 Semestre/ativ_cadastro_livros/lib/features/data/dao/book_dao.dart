import 'package:ativ_cadastro_livros/features/data/models/book.dart';
import 'package:hive/hive.dart';

class BookDAO {
  static const String boxName = 'booksBox';

  static Box<Book> getBox() => Hive.box<Book>(boxName);

  Future<void> addBook(Book book) async {
    final box = getBox();
    await box.add(book);
  }

  List<Book> getAllBooks() {
    final box = getBox();
    return box.values.toList();
  }

  Future<void> updateBook(int index, Book updatedBook) async {
    final box = getBox();
    await box.putAt(index, updatedBook);
  }

  Future<void> deleteBook(int index) async {
    final box = getBox();
    await box.deleteAt(index);
  }

  Future<void> clearAll() async {
    final box = getBox();
    await box.clear();
  }
}