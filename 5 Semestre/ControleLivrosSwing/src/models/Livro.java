package models;

public class Livro {
    private String titulo;
    private String autor;
    private String anoPub;

    public Livro() {
        this.titulo = "Não informado!";
        this.autor = "Não informado!";
        this.anoPub = "Não informado!";
    }
    public Livro(String titulo, String autor, String anoPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(String anoPub) {
        this.anoPub = anoPub;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
    
    
}
