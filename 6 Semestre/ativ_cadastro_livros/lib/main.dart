import 'package:ativ_cadastro_livros/app/themes/app_theme.dart';
import 'package:ativ_cadastro_livros/features/data/dao/book_dao.dart';
import 'package:ativ_cadastro_livros/features/data/models/book.dart';
import 'package:ativ_cadastro_livros/features/presentation/screens/home_page.dart';
import 'package:flutter/material.dart';
import 'package:hive_flutter/hive_flutter.dart';

void main() async {
  await Hive.initFlutter();
  Hive.registerAdapter(BookAdapter());
  await Hive.openBox<Book>(BookDAO.boxName);
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'MyBooks',
      theme: customTheme,
      home: const HomePage(),
    );
  }
}