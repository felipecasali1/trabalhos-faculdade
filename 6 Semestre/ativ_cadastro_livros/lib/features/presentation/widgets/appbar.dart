import 'package:flutter/material.dart';

AppBar buildAppBar(BuildContext context) {
  return AppBar(
    title: Text(
      'MyBooks',
      style: TextStyle(
        fontSize: 24,
        fontWeight: FontWeight.bold,
        color: Colors.white,
        fontStyle: FontStyle.italic
      ),
    ),
    backgroundColor: Colors.blue,
    centerTitle: true,
    leading: Builder(
      builder: (context) => IconButton(
        icon: const Icon(
          Icons.menu,
          color: Colors.white
        ),
        onPressed: () => Scaffold.of(context).openDrawer(),
      ),
    ),
  );
}