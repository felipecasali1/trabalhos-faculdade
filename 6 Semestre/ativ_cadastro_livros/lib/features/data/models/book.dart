import 'package:hive/hive.dart';
part 'book.g.dart';

@HiveType(typeId: 1)
class Book extends HiveObject {
  @HiveField(0)
  String title;

  @HiveField(1)
  String author;
    
  @HiveField(2)
  int publicationYear;

  @HiveField(3)
  String publisher;

  Book({
    required this.title,
    required this.author,
    required this.publicationYear,
    required this.publisher
  });
}