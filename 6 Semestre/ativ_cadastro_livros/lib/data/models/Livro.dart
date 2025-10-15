class Livro {
  int? id;
  String titulo;
  String autor;
  int anoPublicacao;
  String editora;

  Livro({
    this.id,
    required this.titulo,
    required this.autor,
    required this.anoPublicacao,
    required this.editora
  });

  Map<String, dynamic> toMap() {
    return {
      "id": id,
      "titulo": titulo,
      "autor": autor,
      "anoPublicacao": anoPublicacao,
      "editora": editora
    };
  }

  static Livro fromMap(Map<String, dynamic> map) {
    return Livro(
      id: map["id"],
      titulo: map["titulo"],
      autor: map["autor"],
      anoPublicacao: map["anoPublicacao"],
      editora: map["editora"]
    );
  }
}