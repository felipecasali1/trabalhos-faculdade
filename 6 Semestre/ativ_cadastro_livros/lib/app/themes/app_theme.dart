import 'package:flutter/material.dart';

ThemeData customTheme = ThemeData(
  useMaterial3: true,

  colorScheme: ColorScheme.fromSeed(
    seedColor: Colors.blue,
    primary: Colors.blue,
    secondary: Colors.orangeAccent,
    brightness: Brightness.light,
  ),

  appBarTheme: AppBarTheme(
    backgroundColor: Colors.blue,
    elevation: 4,
    centerTitle: true,
    iconTheme: const IconThemeData(color: Colors.white),
    titleTextStyle: TextStyle(
      fontSize: 22,
      fontWeight: FontWeight.bold,
      fontStyle: FontStyle.italic,
      color: Colors.white,
    ),
  ),

  elevatedButtonTheme: ElevatedButtonThemeData(
    style: ElevatedButton.styleFrom(
      backgroundColor: Colors.blue,
      foregroundColor: Colors.white,
      padding: const EdgeInsets.symmetric(vertical: 14, horizontal: 24),
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(12),
      ),
      textStyle: const TextStyle(
        fontWeight: FontWeight.bold,
        fontSize: 16,
      ),
    ),
  ),

  floatingActionButtonTheme: FloatingActionButtonThemeData(
    backgroundColor: Colors.blue,
    foregroundColor: Colors.white,
  ),

  inputDecorationTheme: InputDecorationTheme(
    border: OutlineInputBorder(
      borderRadius: BorderRadius.circular(12),
    ),
    focusedBorder: OutlineInputBorder(
      borderRadius: BorderRadius.circular(12),
      borderSide: BorderSide(color: Colors.blue, width: 2),
    ),
    labelStyle: TextStyle(color: Colors.grey.shade700),
  ),

  textTheme: TextTheme(
    titleLarge: const TextStyle(
      fontSize: 22,
      fontWeight: FontWeight.bold,
      fontStyle: FontStyle.italic,
      color: Colors.black87,
    ),
    bodyMedium: const TextStyle(
      fontSize: 16,
      color: Colors.black87,
    ),
    bodySmall: const TextStyle(
      fontSize: 14,
      color: Colors.black54,
    ),
  ),


  listTileTheme: ListTileThemeData(
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(12),
    ),
    contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
    titleTextStyle: const TextStyle(
      fontWeight: FontWeight.bold,
      fontSize: 16,
      color: Colors.black87,
    ),
    subtitleTextStyle: const TextStyle(
      fontSize: 14,
      color: Colors.black54,
    ),
    iconColor: Colors.blue,
  ),
);