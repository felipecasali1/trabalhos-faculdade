package entities;

public class Musica extends Midia{
    private String artista;

    public Musica() {
        super();
        this.artista = "Nao informado!";
    }

    public Musica(String artista, String nome, Integer duracao) {
        super(nome, duracao);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String listar() {
        return "Nome: " + getNome() + "\nArtista: " + getArtista();
    }

    @Override
    public String reproduzir() {
        return "Reproduzindo: " + getNome() +
                "\nArtista: " + getArtista();
    }    
}
